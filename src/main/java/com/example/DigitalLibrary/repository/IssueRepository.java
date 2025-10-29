package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    
}


