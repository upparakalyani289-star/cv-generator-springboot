package com.kalyani.cv.cvgenerator.service;

import com.kalyani.cv.cvgenerator.dto.ResumeDTO;
import com.kalyani.cv.cvgenerator.entity.Resume;
import com.kalyani.cv.cvgenerator.exception.ResourceNotFoundException;
import com.kalyani.cv.cvgenerator.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    // Entity -> DTO
    private ResumeDTO mapToDTO(Resume resume) {
        ResumeDTO dto = new ResumeDTO();

        dto.setId(resume.getId());
        dto.setFullName(resume.getFullName());
        dto.setEmail(resume.getEmail());
        dto.setPhone(resume.getPhone());
        dto.setAddress(resume.getAddress());
        dto.setEducation(resume.getEducation());
        dto.setSkills(resume.getSkills());
        dto.setExperience(resume.getExperience());

        return dto;
    }

    // DTO -> Entity
    private Resume mapToEntity(ResumeDTO dto) {
        Resume resume = new Resume();

        resume.setId(dto.getId());
        resume.setFullName(dto.getFullName());
        resume.setEmail(dto.getEmail());
        resume.setPhone(dto.getPhone());
        resume.setAddress(dto.getAddress());
        resume.setEducation(dto.getEducation());
        resume.setSkills(dto.getSkills());
        resume.setExperience(dto.getExperience());

        return resume;
    }

    // Create Resume
    public ResumeDTO saveResume(ResumeDTO dto) {
        Resume resume = mapToEntity(dto);
        Resume savedResume = resumeRepository.save(resume);
        return mapToDTO(savedResume);
    }

    // Get All Resumes
    public List<ResumeDTO> getAllResumes() {
        return resumeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get Resume By ID
    public ResumeDTO getResumeById(Long id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resume not found with id: " + id));

        return mapToDTO(resume);
    }

    // Update Resume
    public ResumeDTO updateResume(Long id, ResumeDTO dto) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resume not found with id: " + id));

        resume.setFullName(dto.getFullName());
        resume.setEmail(dto.getEmail());
        resume.setPhone(dto.getPhone());
        resume.setAddress(dto.getAddress());
        resume.setEducation(dto.getEducation());
        resume.setSkills(dto.getSkills());
        resume.setExperience(dto.getExperience());

        Resume updatedResume = resumeRepository.save(resume);

        return mapToDTO(updatedResume);
    }

    // Delete Resume
    public void deleteResume(Long id) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Resume not found with id: " + id));

        resumeRepository.delete(resume);
    }
}