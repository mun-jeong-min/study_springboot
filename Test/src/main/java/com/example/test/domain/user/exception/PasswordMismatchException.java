package com.example.test.domain.user.exception;

import com.example.test.global.error.exception.ErrorCode;
import com.example.test.global.error.exception.TestException;

public class PasswordMismatchException extends TestException {
    public static PasswordMismatchException EXCEPTION =
            new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
