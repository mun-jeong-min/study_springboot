package com.example.test.domain.user.application;

import com.example.test.domain.user.dao.UserRepository;
import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserServicelmpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public String createUser(CreateUserRequest request) {

        userRepository.save(User.builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .build());

        return "create success!!!";
    }
}
