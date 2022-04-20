package com.example.test.domain.user.present.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateUserRequest {
    private String accountId;

    private String password;
    private String username;
}