package com.kalyani.cv.cvgenerator.repository;

import com.kalyani.cv.cvgenerator.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}