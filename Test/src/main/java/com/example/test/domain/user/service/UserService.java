package com.example.test.domain.user.service;

import com.example.test.domain.user.present.dto.request.CreateUserRequest;
import com.example.test.domain.user.present.dto.request.SigninRequest;
import com.example.test.domain.user.present.dto.response.TokenResponse;

public interface UserService {
    String signup(CreateUserRequest request);

    TokenResponse login(SigninRequest request);
}
