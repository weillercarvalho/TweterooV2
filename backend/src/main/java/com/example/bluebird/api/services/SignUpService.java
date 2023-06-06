package com.example.bluebird.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebird.api.models.SignUpModel;
import com.example.bluebird.api.repository.SignUpRepository;

@Service
public class SignUpService {
    @Autowired
    private SignUpRepository repository;

    public void create(SignUpModel data) {
        repository.save(data);
    }
}
