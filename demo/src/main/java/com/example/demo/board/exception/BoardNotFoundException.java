package com.example.demo.board.exception;

import com.example.demo.global.error.exception.DemoException;
import com.example.demo.global.error.exception.ErrorCode;

public class BoardNotFoundException extends DemoException {
    public static BoardNotFoundException EXCEPTION =
            new BoardNotFoundException();

    public BoardNotFoundException() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
