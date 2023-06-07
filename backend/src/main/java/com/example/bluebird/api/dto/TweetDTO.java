package com.example.bluebird.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
    @NotBlank
    String username,
    @NotBlank 
    String avatar,
    @NotBlank 
    String tweet
    ) {
    
}
