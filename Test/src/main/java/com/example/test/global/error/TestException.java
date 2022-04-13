package com.example.test.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class TestException extends RuntimeException{
    private final ErrorCode errorCode;
}
