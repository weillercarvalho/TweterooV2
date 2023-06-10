package com.example.bluebird.api.controllers;

import com.example.bluebird.api.dto.SignUpDTO;
import com.example.bluebird.api.dto.TweetDTO;
import com.example.bluebird.api.error.NotFoundException;
import com.example.bluebird.api.models.SignUpModel;
import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.services.SignUpService;
import com.example.bluebird.api.services.TweetService;
import jakarta.validation.constraints.NotBlank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SignControllerTest {
    @InjectMocks
    private SignController controller;
    @Mock
    private SignUpService service;

    private SignUpModel signUpModel;

    private SignUpDTO signUpDTO;

    private static final Integer ID = 1;
    private static final String username = "Weiller";
    private static final String avatar = "https://i.pinimg.com/originals/2a/92/06/2a9206a4a0d1d23cf92636c42115d054.jpg";
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTweet();
    }

    @Test
    void signUpTestReturnStatusSuccess() {
        when(service.createSignUpService(any())).thenReturn(signUpModel);
        assertEquals(HttpStatus.CREATED, controller.create(signUpDTO).getStatusCode());
    }

    private void startTweet() {
        signUpDTO = new SignUpDTO(username, avatar);
        signUpModel = new SignUpModel(ID, username, avatar);
    }
}