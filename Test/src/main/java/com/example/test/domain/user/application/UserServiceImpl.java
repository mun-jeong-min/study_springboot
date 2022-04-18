package com.example.test.domain.user.application;

import com.example.test.domain.user.dao.UserRepository;
import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import com.example.test.domain.user.dto.request.SigninRequest;
import com.example.test.domain.user.dto.response.TokenResponse;
import com.example.test.domain.user.exception.UserExistsException;
import com.example.test.domain.user.exception.UserNotFoundException;
import com.example.test.global.enums.Authority;
import com.example.test.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String signup(CreateUserRequest request) {

        if (userRepository.findByAccountId(request.getAccountId()).isPresent())
            throw UserExistsException.EXCEPTION;

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority(Authority.USER)
                .build());

        return "create success!!!";
    }

    @Override
    @Transactional(readOnly = true)
    public TokenResponse login(SigninRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException();

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }
}