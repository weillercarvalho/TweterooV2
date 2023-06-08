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
    List<TweetModel> tweets = new ArrayList<>();
    @Autowired
    private TweetRepository repository;

    public List<TweetModel> getAllTweetsService(int page) {
        if (page <= 0) {
            return repository.findAll();
        } else {
            List<TweetModel> paginationTweet = new ArrayList<>();
            paginationTweet.addAll(repository.findAll().subList(repository.findAll().size() - page, repository.findAll().size() - 1));
            return paginationTweet;
        }
        
    }

    public List<TweetModel> getSpecifiedTweetsService(String username) {
        tweets.clear();
        for (int i = 0; i <= repository.findAll().size() - 1; i++) {
            if (repository.findAll().get(i).getUsername().equals(username)) {
                tweets.add(repository.findAll().get(i));
            }            
        }
        return tweets;
    }

    public void createTweetService(TweetModel data) {
        repository.save(data);
    }
}
