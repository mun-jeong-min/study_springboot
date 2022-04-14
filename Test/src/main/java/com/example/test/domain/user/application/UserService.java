package com.example.test.domain.user.application;

import com.example.test.domain.user.dto.request.CreateUserRequest;
import com.example.test.domain.user.dto.request.SigninRequest;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    String signup(CreateUserRequest request);

    String login(SigninRequest request);
}
