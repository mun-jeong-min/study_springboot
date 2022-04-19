package com.example.test.domain.user.exception;

import com.example.test.global.error.exception.ErrorCode;
import com.example.test.global.error.exception.TestException;

public class UserExistsException extends TestException {

    public static UserExistsException EXCEPTION =
            new UserExistsException();

    public UserExistsException() {
        super(ErrorCode.USER_EXIST);
    }
}
