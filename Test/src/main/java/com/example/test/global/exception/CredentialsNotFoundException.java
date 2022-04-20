package com.example.test.global.exception;

import com.example.test.global.error.exception.ErrorCode;
import com.example.test.global.error.exception.TestException;

public class CredentialsNotFoundException extends TestException {

    public static final TestException EXCEPTION =
            new CredentialsNotFoundException();

    private CredentialsNotFoundException() {
        super(ErrorCode.CREDENTIALS_NOT_FOUND);
    }
}
