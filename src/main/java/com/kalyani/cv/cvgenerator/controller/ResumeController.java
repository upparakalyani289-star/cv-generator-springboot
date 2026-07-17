package com.kalyani.cv.cvgenerator.controller;

import com.kalyani.cv.cvgenerator.dto.ResumeDTO;
import com.kalyani.cv.cvgenerator.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping
    public ResumeDTO createResume(@RequestBody ResumeDTO resumeDTO) {
        return resumeService.saveResume(resumeDTO);
    }

    @GetMapping
    public List<ResumeDTO> getAllResumes() {
        return resumeService.getAllResumes();
    }

    @GetMapping("/{id}")
    public ResumeDTO getResumeById(@PathVariable Long id) {
        return resumeService.getResumeById(id);
    }

    @PutMapping("/{id}")
    public ResumeDTO updateResume(@PathVariable Long id, @RequestBody ResumeDTO resumeDTO) {
        return resumeService.updateResume(id, resumeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return "Resume deleted successfully";
    }
}