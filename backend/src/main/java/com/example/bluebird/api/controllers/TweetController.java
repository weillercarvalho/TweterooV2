package com.example.bluebird.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/all")
    public List<TweetModel> getAllTweet() {
        return service.getAllTweetService();
    }

    @GetMapping
    public List<TweetModel> getAllTweetswithPagination(@RequestParam("page") int page) {
        return service.getPaginationTweetsService(page);
    }
    @GetMapping("/{username}")
    public List<TweetModel> getSpecifiedTweets(@PathVariable String username) {
        return service.getSpecifiedTweetsService(username);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid TweetDTO req) {
        service.createTweetService(new TweetModel(req));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
