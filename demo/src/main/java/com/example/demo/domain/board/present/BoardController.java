package com.example.demo.domain.board.present;

import com.example.demo.domain.board.domain.Board;
import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.present.dto.request.BoardUpdateRequest;
import com.example.demo.domain.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardServiceImpl boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void boardCreate(@RequestBody BoardCreateRequest request) {
        boardService.boardCreate(request);
    }
/*
    @GetMapping("/read/{id}")
    public BoardReadResponse boardRead(@PathVariable("id") Long id) {
        return boardService.boardRead(id);
    }
    */

    @GetMapping("/read")
    public List<Board> boardAll() {
        return boardService.boardAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void boardUpdate(@RequestBody BoardUpdateRequest request, @PathVariable("id") Long id) {
        boardService.boardUpdate(request, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void boardDelete(@PathVariable("id") Long id) {
        boardService.boardDelete(id);
    }

    @GetMapping("/read/{id}")
    public Optional<Board> boardReadOne(@PathVariable("id") Long id) {
        return boardService.boardReadOne(id);
    }
}
