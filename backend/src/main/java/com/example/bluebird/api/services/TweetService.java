package com.example.bluebird.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.repository.TweetRepository;


@Service
public class TweetService {
    private List<TweetModel> tweets = new ArrayList<>();


    @Autowired
    private TweetRepository repository;

    public List<TweetModel> getAllTweetsService() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }

    // public Optional<TweetModel> getSpecifiedTweetsService(String username) {
    //     return repository.findAllByUsername();
    // }

    public void createTweetService(TweetModel data) {
        repository.save(data);
    }
}
