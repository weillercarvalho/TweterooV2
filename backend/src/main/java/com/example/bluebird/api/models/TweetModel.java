package com.example.bluebird.api.models;

import com.example.bluebird.api.dto.TweetDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tweets")
public class TweetModel {
    
    public TweetModel(int id, String username, String tweet) {
        this.id = id;
        this.username = username;
        this.tweet = tweet;
    }


    public TweetModel(TweetDTO data) {
        this.username = data.username();
        this.tweet = data.tweet();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255, nullable = false)
    private String username;
    @Column(length = 255, nullable = false)
    private String tweet;
}
