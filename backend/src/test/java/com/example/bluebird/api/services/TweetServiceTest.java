package com.example.bluebird.api.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.repository.TweetRepository;

@SpringBootTest
public class TweetServiceTest {
    @InjectMocks
    private TweetService service;
    @Mock
    private TweetRepository repository;
    private TweetModel tweetModel;
    private List<TweetModel> listModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTweet();
    }


    @Test
    void testCreateTweetService() {

    }

    @Test
    void whenFindAllTweetsReturnAnInstanceOfRepository() {
        Mockito.when(repository.findAll()).thenReturn(listModel);
        List<TweetModel> response = service.getAllTweetService();

        Assertions.assertEquals(listModel, response);
    }

    @Test
    void testGetPaginationTweetsService() {

    }

    @Test
    void testGetSpecifiedTweetsService() {

    }

    private void startTweet() {
        tweetModel = new TweetModel(1, "Weiller", "First tweet");
        listModel = List.of(tweetModel, new TweetModel(2, "Nick", "Second tweet"));
    }
}
