package com.resumeanalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resumeanalyzer.model.entity.Resume;
import com.resumeanalyzer.model.entity.ResumeAnalysis;
import com.resumeanalyzer.repository.ResumeAnalysisRepository;
import com.resumeanalyzer.repository.ResumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeAnalysisRepository analysisRepository;
    private final MlClientService mlClientService;
    private final ObjectMapper objectMapper;

    public ResumeService(
            ResumeRepository resumeRepository,
            ResumeAnalysisRepository analysisRepository,
            MlClientService mlClientService,
            ObjectMapper objectMapper
    ) {
        this.resumeRepository = resumeRepository;
        this.analysisRepository = analysisRepository;
        this.mlClientService = mlClientService;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Map<String, Object> analyzeAndSaveResume(MultipartFile file, String rawText, String filename, String targetRole) {
        // 1. Call ML microservice
        Map<String, Object> mlResult = mlClientService.analyzeResume(file, rawText, targetRole);

        // 2. Extract metadata
        String resolvedFilename = filename != null ? filename : (file != null ? file.getOriginalFilename() : "resume.txt");
        String fileType = file != null ? file.getContentType() : "text/plain";
        String extractedRawText = (String) mlResult.getOrDefault("raw_text", rawText != null ? rawText : "");

        Map<String, Object> contact = (Map<String, Object>) mlResult.getOrDefault("candidate_info", Collections.emptyMap());
        String candidateName = (String) contact.getOrDefault("name", "Candidate");
        String email = (String) contact.get("email");
        String phone = (String) contact.get("phone");
        String linkedin = (String) contact.get("linkedin");
        String github = (String) contact.get("github");

        // 3. Save Resume Entity
        Resume resume = new Resume(resolvedFilename, fileType, extractedRawText, candidateName, email, phone, linkedin, github);
        resume = resumeRepository.save(resume);

        // 4. Extract and Save Analysis Entity
        Map<String, Object> atsScoreMap = (Map<String, Object>) mlResult.getOrDefault("ats_score", Collections.emptyMap());
        Map<String, Object> subscores = (Map<String, Object>) atsScoreMap.getOrDefault("subscores", Collections.emptyMap());
        Map<String, Object> skillsMap = (Map<String, Object>) mlResult.getOrDefault("skills", Collections.emptyMap());

        ResumeAnalysis analysis = new ResumeAnalysis();
        analysis.setResume(resume);

        Number overallScore = (Number) atsScoreMap.getOrDefault("overall_ats_score", 0.0);
        analysis.setOverallAtsScore(overallScore != null ? overallScore.doubleValue() : 0.0);
        analysis.setGrade((String) atsScoreMap.getOrDefault("grade", "N/A"));
        analysis.setStatusComment((String) atsScoreMap.getOrDefault("status", ""));

        Number totalSkills = (Number) skillsMap.getOrDefault("total_skills_count", 0);
        analysis.setTotalSkillsCount(totalSkills != null ? totalSkills.intValue() : 0);

        if (subscores.containsKey("keywords_and_skills")) {
            Map<String, Object> sub = (Map<String, Object>) subscores.get("keywords_and_skills");
            analysis.setKeywordScore(((Number) sub.getOrDefault("score", 0.0)).doubleValue());
        }
        if (subscores.containsKey("quantifiable_impact")) {
            Map<String, Object> sub = (Map<String, Object>) subscores.get("quantifiable_impact");
            analysis.setImpactScore(((Number) sub.getOrDefault("score", 0.0)).doubleValue());
        }
        if (subscores.containsKey("action_verbs")) {
            Map<String, Object> sub = (Map<String, Object>) subscores.get("action_verbs");
            analysis.setActionVerbScore(((Number) sub.getOrDefault("score", 0.0)).doubleValue());
        }
        if (subscores.containsKey("structure_and_completeness")) {
            Map<String, Object> sub = (Map<String, Object>) subscores.get("structure_and_completeness");
            analysis.setStructureScore(((Number) sub.getOrDefault("score", 0.0)).doubleValue());
        }
        if (subscores.containsKey("formatting_and_readability")) {
            Map<String, Object> sub = (Map<String, Object>) subscores.get("formatting_and_readability");
            analysis.setFormattingScore(((Number) sub.getOrDefault("score", 0.0)).doubleValue());
        }

        try {
            analysis.setExtractedSkillsJson(objectMapper.writeValueAsString(skillsMap.getOrDefault("skills_list", Collections.emptyList())));
            analysis.setCategorizedSkillsJson(objectMapper.writeValueAsString(skillsMap.getOrDefault("categorized_skills", Collections.emptyMap())));
            analysis.setRoleMatchesJson(objectMapper.writeValueAsString(mlResult.getOrDefault("role_matches", Collections.emptyList())));
            analysis.setSuggestionsJson(objectMapper.writeValueAsString(mlResult.getOrDefault("suggestions", Collections.emptyMap())));
            analysis.setRoadmapJson(objectMapper.writeValueAsString(mlResult.getOrDefault("roadmap", Collections.emptyMap())));
            analysis.setFullAnalysisJson(objectMapper.writeValueAsString(mlResult));
        } catch (Exception e) {
            analysis.setFullAnalysisJson("{}");
        }

        analysisRepository.save(analysis);

        // Include generated IDs in response
        mlResult.put("resume_id", resume.getId());
        mlResult.put("analysis_id", analysis.getId());
        mlResult.put("filename", resume.getFilename());
        mlResult.put("created_at", resume.getCreatedAt());

        return mlResult;
    }

    public List<Map<String, Object>> getAllResumes() {
        List<Resume> resumes = resumeRepository.findAllByOrderByCreatedAtDesc();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Resume resume : resumes) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", resume.getId());
            item.put("filename", resume.getFilename());
            item.put("candidate_name", resume.getCandidateName());
            item.put("email", resume.getEmail());
            item.put("created_at", resume.getCreatedAt());

            Optional<ResumeAnalysis> analysisOpt = analysisRepository.findByResume(resume);
            if (analysisOpt.isPresent()) {
                ResumeAnalysis analysis = analysisOpt.get();
                item.put("overall_ats_score", analysis.getOverallAtsScore());
                item.put("grade", analysis.getGrade());
                item.put("total_skills_count", analysis.getTotalSkillsCount());
            }

            result.add(item);
        }

        return result;
    }

    public Map<String, Object> getResumeAnalysis(Long id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found with id: " + id));

        ResumeAnalysis analysis = analysisRepository.findByResume(resume)
                .orElseThrow(() -> new RuntimeException("Analysis not found for resume id: " + id));

        try {
            Map<String, Object> fullAnalysis = objectMapper.readValue(analysis.getFullAnalysisJson(), Map.class);
            fullAnalysis.put("resume_id", resume.getId());
            fullAnalysis.put("analysis_id", analysis.getId());
            fullAnalysis.put("filename", resume.getFilename());
            fullAnalysis.put("created_at", resume.getCreatedAt());
            return fullAnalysis;
        } catch (Exception e) {
            Map<String, Object> basic = new HashMap<>();
            basic.put("resume_id", resume.getId());
            basic.put("filename", resume.getFilename());
            basic.put("overall_ats_score", analysis.getOverallAtsScore());
            basic.put("grade", analysis.getGrade());
            return basic;
        }
    }

    @Transactional
    public void deleteResume(Long id) {
        Optional<Resume> resumeOpt = resumeRepository.findById(id);
        if (resumeOpt.isPresent()) {
            Resume resume = resumeOpt.get();
            analysisRepository.findByResume(resume).ifPresent(analysisRepository::delete);
            resumeRepository.delete(resume);
        }
    }
}
