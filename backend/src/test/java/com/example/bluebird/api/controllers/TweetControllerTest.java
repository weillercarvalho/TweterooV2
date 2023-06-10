package com.example.bluebird.api.controllers;

import com.example.bluebird.api.dto.TweetDTO;
import com.example.bluebird.api.error.NotFoundException;
import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.services.TweetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TweetControllerTest {
    @InjectMocks
    private TweetController controller;
    @Mock
    private TweetService service;

    private TweetModel tweetModel;

    private TweetDTO tweetDTO;

    private List<TweetModel> listModel;

    private NotFoundException notFound;

    private static final Integer ID = 1;
    private static final String username = "Weiller";
    private static final String tweet = "First tweet";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTweet();
    }

    @Test
    void whenGetAllTweetReturnList() {
        when(service.getAllTweetService()).thenReturn(listModel);
        List<TweetModel> response = controller.getAllTweet();
        assertEquals(listModel.getClass(), response.getClass());
        assertNotNull(response);
        assertEquals(ID, response.get(0).getId());
        assertEquals(username, response.get(0).getUsername());
    }

    @Test
    void whenGetAllTweetswithPaginationReturnList() {
        when(service.getPaginationTweetsService(2)).thenReturn(listModel);
        List<TweetModel> response = controller.getAllTweetswithPagination(2);
        assertNotNull(response);
        assertEquals(2, response.size());
    }

    @Test
    void whenGetAllTweetswithPaginationReturnError() {
        when(service.getPaginationTweetsService(0)).thenThrow(new NotFoundException("Page integer invalid"));
        Assertions.assertThrows(NotFoundException.class, () -> controller.getAllTweetswithPagination(0));
    }

    @Test
    void getSpecifiedTweets() {
        when(service.getSpecifiedTweetsService(username)).thenReturn(listModel);
        List<TweetModel> response = controller.getSpecifiedTweets(username);
        assertNotNull(response);
        assertEquals(listModel.getClass(), response.getClass());
        assertEquals(username, response.get(0).getUsername());
    }

    @Test
    void create() {
        when(service.createTweetService(tweetModel)).thenReturn(tweetModel);
        //Continue here!
    }

    private void startTweet() {
        tweetModel = new TweetModel(ID, username, tweet);
        listModel = List.of(tweetModel);
    }
}