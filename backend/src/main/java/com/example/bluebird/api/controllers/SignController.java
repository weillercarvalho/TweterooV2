package com.example.bluebird.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("sign-up")
    public void signUp(@RequestBody @Valid SignUpDTO req) {
        service.create(new SignUpModel(req));
    }
}
