package com.example.demo.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    BOARD_NOT_FOUND(404, "BOARD-404-1", "UserNotFound");

    private final int status;
    private final String code;
    private final String message;
}
