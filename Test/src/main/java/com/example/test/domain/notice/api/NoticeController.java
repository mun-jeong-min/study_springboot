package com.example.test.domain.notice.api;

import com.example.test.domain.notice.application.NoticeService;
import com.example.test.domain.notice.domain.Notice;
import com.example.test.domain.notice.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.dto.request.UpdateNoticeRequest;
import lombok.RequiredArgsConstructor;
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
    public void create(@RequestBody @Valid CreateNoticeRequest noticeRequest) {
        noticeService.create(noticeRequest);
    }

    @GetMapping("/get")
    public List<Notice> read() {
        return noticeService.read();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/put/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody @Valid UpdateNoticeRequest request) {
        noticeService.update(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        noticeService.delete(id);
    }
}