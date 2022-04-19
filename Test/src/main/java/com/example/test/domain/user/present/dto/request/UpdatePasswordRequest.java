package com.example.test.domain.user.present.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdatePasswordRequest {
    private String accountId;
    private String password;
}
