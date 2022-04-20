package com.example.test.global.facade;

import com.example.test.global.exception.CredentialsNotFoundException;
import com.example.test.global.security.auth.AuthDetails;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthFacade {
    public AuthDetails getCurrentDetails() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!(principal instanceof AuthDetails)) {
            throw CredentialsNotFoundException.EXCEPTION;
        }
        return (AuthDetails) principal;
    }
}
