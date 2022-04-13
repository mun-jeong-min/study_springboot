package com.example.test.domain.user.application;

import com.example.test.domain.user.dao.UserRepository;
import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public String createUser(CreateUserRequest request) {

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(request.getPassword())
                .build());

        return "create success!!!";
    }
}