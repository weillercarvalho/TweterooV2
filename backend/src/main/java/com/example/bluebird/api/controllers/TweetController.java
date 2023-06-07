package com.example.bluebird.api.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bluebird.api.dto.TweetDTO;
import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public void getAllTweets() {

    }
    @GetMapping("/{id}")
    public Optional<TweetModel> getSpecifiedTweets(@PathVariable Long id) {
        return service.getSpecifiedTweetsService(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid TweetDTO req) {
        service.createTweetService(new TweetModel(req));
    }
}
