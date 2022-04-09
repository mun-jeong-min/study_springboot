package com.example.test.controller;

import com.example.test.dto.CreateNoticeRequest;
import com.example.test.service.NoticeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class NoticeController {

    private final NoticeService noticeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public void create(@RequestBody CreateNoticeRequest noticeRequest) {
        noticeService.create(noticeRequest);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/get")
    public void read() {
        noticeService.read();
    }
}