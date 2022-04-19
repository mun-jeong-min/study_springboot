package com.example.test.domain.notice.exception;

import com.example.test.global.error.exception.ErrorCode;
import com.example.test.global.error.exception.TestException;

public class NoticeNotFoundException extends TestException {

    public static NoticeNotFoundException EXCEPTION =
            new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
