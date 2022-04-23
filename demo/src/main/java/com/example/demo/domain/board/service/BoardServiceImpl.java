package com.example.demo.domain.board.service;

import com.example.demo.domain.board.domain.Board;
import com.example.demo.domain.board.domain.repository.BoardRepository;
import com.example.demo.domain.board.exception.BoardNotFoundException;
import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.present.dto.request.BoardUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    /*
    @Override
    public BoardReadResponse boardRead(Long id) {
        List<BoardResponse> boardReadList = boardRepository.findAllById(id)
                .stream()
                .map(board -> BoardResponse.builder()
                        .title(board.getTitle())
                        .description(board.getDescription())
                        .subTitle(board.getSubTitle())
                        .build())
                .collect(Collectors.toList());

        return new BoardReadResponse(boardReadList);
    }
    */

    @Override
    public List<Board> boardAll() {
        return (List<Board>) boardRepository.findAll();
    }

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

    @Override
    public Optional<Board> boardReadOne(Long id) {
        return boardRepository.findBoardById(id);
    }
}