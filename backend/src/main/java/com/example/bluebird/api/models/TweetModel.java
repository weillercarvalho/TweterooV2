package com.example.bluebird.api.models;

import com.example.bluebird.api.dto.TweetDTO;
import jakarta.persistence.*;

public class TweetModel {

    public TweetModel(TweetDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
        this.tweet = data.tweet();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 255, nullable = false)
    private String username;
    @Column(length = 255, nullable = false)
    private String avatar;
    @Column(length = 255, nullable = false)
    private String tweet;
}
