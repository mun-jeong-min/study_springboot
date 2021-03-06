package com.example.test.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    PASSWORD_MISMATCH(401,"USER-401-1","PasswordNotFound"),
    CREDENTIALS_NOT_FOUND(401,"GLOBAL-401-1", "Credentials not found"),

    USER_NOT_FOUND(404,"USER-404-1","UserNotFound"),
    NOTICE_NOT_FOUND(404,"NOTICE-404-1","NoticeNotFound"),

    USER_EXIST(409,"USER-409-1","User Exist");

    private final int status;
    private final String code;
    private final String message;
}