package com.example.demo.domain.board.service;

import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.present.dto.request.BoardUpdateRequest;

public interface BoardService {
    void boardCreate(BoardCreateRequest request);

    void boardUpdate(BoardUpdateRequest request, Long id);

    void boardDelete(Long id);
}
