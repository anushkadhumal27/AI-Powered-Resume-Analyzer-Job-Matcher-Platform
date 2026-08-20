package com.resumeanalyzer.controller;

import com.resumeanalyzer.model.dto.CompareRequestDto;
import com.resumeanalyzer.model.entity.JobComparison;
import com.resumeanalyzer.model.entity.JobRole;
import com.resumeanalyzer.service.JobMatchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobMatchController {

    private final JobMatchingService jobMatchingService;

    public JobMatchController(JobMatchingService jobMatchingService) {
        this.jobMatchingService = jobMatchingService;
    }

    /**
     * Get all pre-seeded benchmark job roles.
     */
    @GetMapping("/roles")
    public ResponseEntity<List<JobRole>> getAllJobRoles() {
        return ResponseEntity.ok(jobMatchingService.getAllJobRoles());
    }

    /**
     * Compare a resume with a custom Job Description.
     */
    @PostMapping("/compare")
    public ResponseEntity<Map<String, Object>> compareWithJobDescription(@RequestBody CompareRequestDto request) {
        Map<String, Object> result = jobMatchingService.compareWithJobDescription(request);
        return ResponseEntity.ok(result);
    }

    /**
     * Get past comparisons for a specific resume.
     */
    @GetMapping("/comparisons/{resumeId}")
    public ResponseEntity<List<JobComparison>> getComparisonsByResumeId(@PathVariable Long resumeId) {
        return ResponseEntity.ok(jobMatchingService.getComparisonsByResumeId(resumeId));
    }
}
