package com.example.test.domain.user.present;

import com.example.test.domain.user.present.dto.request.UpdatePasswordRequest;
import com.example.test.domain.user.present.dto.response.ProfileResponse;
import com.example.test.domain.user.service.UserService;
import com.example.test.domain.user.present.dto.request.CreateUserRequest;
import com.example.test.domain.user.present.dto.request.SignInRequest;
import com.example.test.domain.user.present.dto.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public String signup(@RequestBody @Valid CreateUserRequest request) {
        return userService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid SignInRequest request) {
        return userService.login(request);
    }

    @PutMapping("/pwd")
    public void updatePassword(@RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);
    }

    @GetMapping("/profile")
    public ProfileResponse userProfile() {
        return userService.userProfile();
    }
}