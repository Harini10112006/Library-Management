package com.example.DigitalLibrary.repository;

import com.example.DigitalLibrary.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    
}
