package com.devpriya.Social_Bookmarking_Discovery_Backend.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}