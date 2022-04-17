package com.example.test.domain.user.application;

import com.example.test.domain.user.dto.request.CreateUserRequest;
import com.example.test.domain.user.dto.request.SigninRequest;
import com.example.test.domain.user.dto.response.TokenResponse;

public interface UserService {
    String signup(CreateUserRequest request);

    TokenResponse login(SigninRequest request);
}
