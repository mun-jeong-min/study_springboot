package com.example.test.domain.auth.present;

import com.example.test.domain.user.present.dto.request.SignInRequest;
import com.example.test.domain.user.present.dto.response.TokenResponse;
import com.example.test.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
//@RequestMapping("/user")
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid SignInRequest request) {
        return userService.login(request);
    }
}
