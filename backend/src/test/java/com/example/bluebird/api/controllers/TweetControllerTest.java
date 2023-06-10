package com.example.bluebird.api.controllers;

import com.example.bluebird.api.services.TweetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TweetControllerTest {
    @InjectMocks
    private TweetController controller;
    @Mock
    private TweetService service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTweet() {
    }

    @Test
    void getAllTweetswithPagination() {
    }

    @Test
    void getSpecifiedTweets() {
    }

    @Test
    void create() {
    }
}