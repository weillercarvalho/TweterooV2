package com.example.bluebird.api.dto;

import jakarta.validation.constraints.NotBlank;

public record SignUpDTO(
    @NotBlank
    String username,
    @NotBlank 
    String avatar
    ) {
    
}
