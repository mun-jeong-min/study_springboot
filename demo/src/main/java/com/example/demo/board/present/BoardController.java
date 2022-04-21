package com.example.demo.board.present;

import com.example.demo.board.present.dto.request.BoardCreateRequest;
import com.example.demo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void boardCreate(@RequestBody BoardCreateRequest request) {
        boardService.boardCreate(request);
    }
}
