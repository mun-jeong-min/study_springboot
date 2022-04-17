package com.example.test.domain.user.api;

import com.example.test.domain.user.application.UserServiceImpl;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import com.example.test.domain.user.dto.request.SigninRequest;
import com.example.test.domain.user.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public String signup(@RequestBody @Valid CreateUserRequest request) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid SigninRequest request) {
        return userService.login(request);
    }
}