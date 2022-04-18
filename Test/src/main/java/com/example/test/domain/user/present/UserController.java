package com.example.test.domain.user.present;

import com.example.test.domain.user.service.UserServiceImpl;
import com.example.test.domain.user.present.dto.request.CreateUserRequest;
import com.example.test.domain.user.present.dto.request.SigninRequest;
import com.example.test.domain.user.present.dto.response.TokenResponse;
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