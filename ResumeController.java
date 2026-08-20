package com.resumeanalyzer.controller;

import com.resumeanalyzer.model.dto.TextAnalyzeRequestDto;
import com.resumeanalyzer.service.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    /**
     * Upload resume file (PDF, DOCX, TXT) and run complete AI analysis.
     */
    @PostMapping("/upload")
    public ResponseEntity<Map<String, Object>> uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "target_role", required = false, defaultValue = "Full Stack Software Engineer") String targetRole
    ) {
        Map<String, Object> result = resumeService.analyzeAndSaveResume(file, null, file.getOriginalFilename(), targetRole);
        return ResponseEntity.ok(result);
    }

    /**
     * Analyze resume text directly via JSON body.
     */
    @PostMapping("/analyze-text")
    public ResponseEntity<Map<String, Object>> analyzeText(@RequestBody TextAnalyzeRequestDto request) {
        String filename = request.getFilename() != null ? request.getFilename() : "pasted_resume.txt";
        String targetRole = request.getTargetRole() != null ? request.getTargetRole() : "Full Stack Software Engineer";
        Map<String, Object> result = resumeService.analyzeAndSaveResume(null, request.getText(), filename, targetRole);
        return ResponseEntity.ok(result);
    }

    /**
     * Retrieve all past resume scans.
     */
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllResumes() {
        return ResponseEntity.ok(resumeService.getAllResumes());
    }

    /**
     * Retrieve single resume analysis by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getResumeAnalysis(@PathVariable Long id) {
        return ResponseEntity.ok(resumeService.getResumeAnalysis(id));
    }

    /**
     * Delete resume scan and analysis by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return ResponseEntity.ok(Map.of("message", "Resume deleted successfully", "id", id.toString()));
    }
}
