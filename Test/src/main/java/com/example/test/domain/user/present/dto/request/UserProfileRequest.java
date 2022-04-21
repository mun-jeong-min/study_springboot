package com.example.test.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserProfileRequest {
    private String accountId;
    private String username;
}
