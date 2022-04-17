package com.example.test.global.error.exception;

import com.example.test.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class TestException extends RuntimeException{
    private final ErrorCode errorCode;
}
