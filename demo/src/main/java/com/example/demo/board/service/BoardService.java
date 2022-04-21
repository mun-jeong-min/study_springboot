package com.example.demo.board.service;

import com.example.demo.board.present.dto.request.BoardCreateRequest;

public interface BoardService {
    void boardCreate(BoardCreateRequest request);
}
