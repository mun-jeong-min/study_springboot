package com.example.test.domain.notice.exception;

import com.example.test.global.error.ErrorCode;
import com.example.test.global.error.TestException;

public class NoticeNotFoundException extends TestException {

    public static NoticeNotFoundException EXCEPTION =
            new NoticeNotFoundException();

    public NoticeNotFoundException() {
        super(ErrorCode.NOTICE_NOT_FOUND);
    }
}
