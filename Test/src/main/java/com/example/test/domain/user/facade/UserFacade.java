package com.example.test.domain.user.facade;

import com.example.test.domain.user.domain.User;
import com.example.test.domain.user.domain.repository.UserRepository;
import com.example.test.domain.user.exception.UserNotFoundException;
import com.example.test.global.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final AuthFacade authFacade;
    private final UserRepository userRepository;

    public User getCurrentUser() {
        return userRepository.findByUsername(authFacade.getCurrentDetails().getUsername())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
