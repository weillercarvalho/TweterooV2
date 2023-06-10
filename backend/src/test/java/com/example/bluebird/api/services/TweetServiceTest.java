package com.example.bluebird.api.services;

import java.util.ArrayList;
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

    private NotFoundException notFound;
    List<TweetModel> tweets = new ArrayList<>();

    private static final Integer ID = 1;
    private static final String username = "Weiller";
    private static final String tweet = "First tweet";
    private static final int pageInvalid = 0;
    private static final int pageValid = 3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startTweet();
    }


    @Test
    void testCreateTweetService() {
     when(repository.save(Mockito.any())).thenReturn(tweetModel);
     TweetModel response = service.createTweetService(tweetModel);
     assertNotNull(response);
     assertEquals(TweetModel.class, response.getClass());
    }

    @Test
    void whenFindAllTweetsReturnAnInstanceOfRepository() {
        when(repository.findAll()).thenReturn(listModel);
        List<TweetModel> response = service.getAllTweetService();
        TweetModel responseone = service.getAllTweetService().get(0);
        assertNotNull(response);
        assertEquals(listModel, response);
        assertEquals(ID, responseone.getId());
        assertEquals(TweetModel.class, responseone.getClass());
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void testGetPaginationTweetsServiceErrorNotFound(int page) {
            when(repository.findAll().subList(page, page)).thenThrow(new NotFoundException("Page integer invalid"));
            Assertions.assertThrows(NotFoundException.class, () -> service.getPaginationTweetsService(page));
    }
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testGetPaginationTweetsServiceSucess(int page) {
            int totalSize = repository.findAll().size();
            int startIndex = totalSize - page;
            int endIndex = totalSize;

            if (startIndex < 0) {
                startIndex = 0;
            }
            when(repository.findAll().subList(startIndex, endIndex)).thenReturn(listModel);
            Assertions.assertEquals(page, service.getPaginationTweetsService(page).size());
    }

    @Test
    void testGetSpecifiedTweetsService() {
        when(repository.findAll()).thenReturn(tweets);
        tweets.add(tweetModel);
        List<TweetModel> response = service.getSpecifiedTweetsService(username);
        assertEquals(tweets.getClass(),response.getClass());
        assertNotNull(response);
        assertEquals(tweets.get(0).getUsername(), response.get(0).getUsername());

    }

    private void startTweet() {
        tweetModel = new TweetModel(ID, username, tweet);
        listModel = List.of(tweetModel, new TweetModel(2, "Nick", "Second tweet"));
    }
}
