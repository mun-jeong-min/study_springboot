package com.example.demo.board.service;

import com.example.demo.board.domain.Board;
import com.example.demo.board.domain.repository.BoardRepository;
import com.example.demo.board.present.dto.request.BoardCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    public void boardCreate(BoardCreateRequest request) {
        boardRepository.save(
                Board.builder()
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .subTitle(request.getSubtitle())
                        .build()
        );
    }
}
