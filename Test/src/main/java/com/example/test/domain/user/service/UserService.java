package com.example.test.domain.user.service;

import com.example.test.domain.user.present.dto.request.CreateUserRequest;
import com.example.test.domain.user.present.dto.request.SignInRequest;
import com.example.test.domain.user.present.dto.request.UpdatePasswordRequest;
import com.example.test.domain.user.present.dto.response.TokenResponse;

public interface UserService {
    String signup(CreateUserRequest request);

    TokenResponse login(SignInRequest request);

    void updatePassword(UpdatePasswordRequest request);
}
