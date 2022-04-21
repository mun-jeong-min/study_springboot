package com.example.demo.domain.board.service;

import com.example.demo.domain.board.domain.Board;
import com.example.demo.domain.board.domain.repository.BoardRepository;
import com.example.demo.domain.board.exception.BoardNotFoundException;
import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.present.dto.request.BoardUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                        .subTitle(request.getSubTitle())
                        .build()
        );
    }

    @Override
    @Transactional
    public void boardUpdate(BoardUpdateRequest request, Long id) {
        Board board = boardRepository.findBoardById(id)
                .orElseThrow(() -> BoardNotFoundException.EXCEPTION);

        board.updateBoard(request.getTitle(), request.getDescription(), request.getSubTitle());
    }

    @Override
    @Transactional
    public void boardDelete(Long id) {
        boardRepository.deleteById(id);
    }


}