package com.example.demo.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DemoException extends RuntimeException{
    private final ErrorCode errorCode;
}
