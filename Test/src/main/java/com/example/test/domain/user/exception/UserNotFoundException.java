package com.example.test.domain.user.exception;

import com.example.test.global.error.ErrorCode;
import com.example.test.global.error.exception.TestException;

public class UserNotFoundException extends TestException {
    public static UserNotFoundException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
