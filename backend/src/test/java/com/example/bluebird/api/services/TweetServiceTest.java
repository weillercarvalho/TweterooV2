package com.example.bluebird.api.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.bluebird.api.error.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.repository.TweetRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TweetServiceTest {
    @InjectMocks
    private TweetService service;
    @Mock
    private TweetRepository repository;
    private TweetModel tweetModel;
    private List<TweetModel> listModel;

    private static final Integer ID = 1;
    private static final String username = "Weiller";
    private static final String tweet = "First tweet";
    private static final int pageInvalid = 0;
    private static final int pageValid = 3;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        startTweet();
    }


    @Test
    void testCreateTweetService() {

    }

    @Test
    void whenFindAllTweetsReturnAnInstanceOfRepository() {
        when(repository.findAll()).thenReturn(listModel);
        List<TweetModel> response = service.getAllTweetService();
        TweetModel responseone = service.getAllTweetService().get(0);
        assertNotNull(response);
        assertEquals(listModel, response);
        assertEquals(ID, responseone.getId());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void testGetPaginationTweetsService(int page) {

        if (page <= 0) {
            Assertions.assertThrows(NotFoundException.class, () -> service.getPaginationTweetsService(page));
        } else {
            int totalSize = repository.findAll().size();
            int startIndex = totalSize - page;
            int endIndex = totalSize;

            if (startIndex < 0) {
                startIndex = 0;
            }
            when(repository.findAll().subList(startIndex, endIndex)).thenReturn(listModel);
            Assertions.assertEquals(page, service.getPaginationTweetsService(page).size());
        }
    }

    @Test
    void testGetSpecifiedTweetsService() {

    }

    private void startTweet() {
        tweetModel = new TweetModel(ID, username, tweet);
        listModel = List.of(tweetModel, new TweetModel(2, "Nick", "Second tweet"));
    }
}
