package com.example.demo.domain.board.service;

import com.example.demo.domain.board.domain.Board;
import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.present.dto.request.BoardUpdateRequest;
import com.example.demo.domain.board.present.dto.response.BoardReadResponse;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    /*BoardReadResponse boardRead(Long id);*/

    List<Board> boardAll();

    void boardCreate(BoardCreateRequest request);

    void boardUpdate(BoardUpdateRequest request, Long id);

    void boardDelete(Long id);

    Optional<Board> boardReadOne(Long id);

    BoardReadResponse boardRead(Long id);
}
