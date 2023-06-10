package com.example.bluebird.api.services;

import com.example.bluebird.api.models.SignUpModel;
import com.example.bluebird.api.models.TweetModel;
import com.example.bluebird.api.repository.SignUpRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

@SpringBootTest
public class SignUpServiceTest {
    @InjectMocks
    private SignUpService service;
    @Mock
    private SignUpRepository repository;

    private SignUpModel signUpModel;
    private static final Integer ID = 1;
    private static final String username = "Weiller";
    private static final String avatar = "https://i.pinimg.com/originals/2a/92/06/2a9206a4a0d1d23cf92636c42115d054.jpg";
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startSignUp();
    }

    @Test
    void whenCreateSignUpReturnData() {
        when(repository.save(Mockito.any())).thenReturn(signUpModel);
        SignUpModel response = service.createSignUpService(signUpModel);
        assertEquals(SignUpModel.class, response.getClass());
        assertNotNull(response);
        assertEquals(ID, response.getId());
    }
    private void startSignUp() {
        signUpModel = new SignUpModel(ID, username, avatar);
    }
}
