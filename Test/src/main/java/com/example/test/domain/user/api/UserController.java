package com.example.test.domain.user.api;

import com.example.test.domain.user.application.UserServicelmpl;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServicelmpl userServicelmpl;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/login")
    public String login (@RequestBody @Valid CreateUserRequest request) {
        return userServicelmpl.createUser(request);
    }
}