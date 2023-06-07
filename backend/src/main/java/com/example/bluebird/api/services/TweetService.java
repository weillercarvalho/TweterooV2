package com.example.bluebird.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.repository.TweetRepository;

public class TweetService {
    @Autowired
    private TweetRepository repository;

    public List<TweetModel> getAllTweetsService() {
        return repository.findAll();
    }

    public Optional<TweetModel> getSpecifiedTweetsService(Long id) {
        return repository.findById(id);
    }

    public void createTweetService(TweetModel data) {
        repository.save(data);
    }

}
