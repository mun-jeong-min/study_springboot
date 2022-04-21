package com.example.demo.domain.board.present;

import com.example.demo.domain.board.present.dto.request.BoardCreateRequest;
import com.example.demo.domain.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
