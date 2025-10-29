package com.example.DigitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.DigitalLibrary.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
