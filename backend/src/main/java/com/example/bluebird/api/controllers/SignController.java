package com.example.bluebird.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bluebird.api.dto.SignUpDTO;
import com.example.bluebird.api.models.SignUpModel;
import com.example.bluebird.api.services.SignUpService;

import jakarta.validation.Valid;

@RestController
public class SignController {
    @Autowired
    private SignUpService service;

    @PostMapping("/api/sign-up")
    public ResponseEntity<Void> create(@RequestBody @Valid SignUpDTO req) {
        service.createSignUpService(new SignUpModel(req));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
