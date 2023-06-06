package com.example.bluebird.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bluebird.api.models.SignUpModel;

public interface SignUpRepository extends JpaRepository<SignUpModel, Long> {
    
}
