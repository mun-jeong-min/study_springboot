package com.example.test.domain.user.application;

import com.example.test.domain.user.dto.request.CreateUserRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserService {
    String createUser(CreateUserRequest request);
}
