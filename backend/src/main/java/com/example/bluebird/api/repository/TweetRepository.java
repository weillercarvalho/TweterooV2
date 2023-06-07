package com.example.bluebird.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bluebird.api.models.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {
    
}
