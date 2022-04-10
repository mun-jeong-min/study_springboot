package com.example.test.controller;

import com.example.test.dto.CreateNoticeRequest;
import com.example.test.entity.Notice;
import com.example.test.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class NoticeController {

    private final NoticeService noticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public String create(@RequestBody @Valid CreateNoticeRequest noticeRequest) {
        return noticeService.create(noticeRequest);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/get")
    public List<Notice> read() {

        return noticeService.read();
    }
}