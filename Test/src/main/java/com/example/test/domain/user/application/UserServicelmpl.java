package com.example.test.domain.user.application;

import com.example.test.domain.user.dao.UserRepository;
import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import com.example.test.domain.user.dto.request.SigninRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public String signup(CreateUserRequest request) {

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(request.getPassword())
                .build());

        return "create success!!!";
    }

    @Override
    @Transactional
    public String signin(SigninRequest request) {
        Optional<User> user = userRepository.findByAccountId(request.getAccountId());

        return "login success!!!";
    }
}