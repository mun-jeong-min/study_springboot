package com.example.test.domain.user.service;

import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.domain.repository.UserRepository;
import com.example.test.domain.user.exception.PasswordMismatchException;
import com.example.test.domain.user.exception.UserExistsException;
import com.example.test.domain.user.exception.UserNotFoundException;
import com.example.test.domain.user.facade.UserFacade;
import com.example.test.domain.user.present.dto.request.CreateUserRequest;
import com.example.test.domain.user.present.dto.request.SignInRequest;
import com.example.test.domain.user.present.dto.request.UpdatePasswordRequest;
import com.example.test.domain.user.present.dto.request.UserProfileRequest;
import com.example.test.domain.user.present.dto.response.ProfileResponse;
import com.example.test.domain.user.present.dto.response.TokenResponse;
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
    private final UserFacade userFacade;

    @Override
    public String signup(CreateUserRequest request) {
        if (userRepository.findByAccountId(request.getAccountId()).isPresent()) {
            throw UserExistsException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .authority(Authority.USER)
                .username(request.getUsername())
                .build());

        return "create success!!!";
    }

    @Override
    @Transactional(readOnly = true)
    public TokenResponse login(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        String access = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refresh = jwtTokenProvider.generateRefreshToken(request.getAccountId());

        return TokenResponse.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .authority(user.getAuthority())
                .build();
    }

    @Override
    @Transactional
    public void updatePassword(UpdatePasswordRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        user.updatePassword(passwordEncoder.encode(request.getPassword()));
    }

    @Override
    public ProfileResponse userProfile() {
        User user = userFacade.getCurrentUser();

        return ProfileResponse.builder()
                .username(user.getUsername())
                .build();
    }
}