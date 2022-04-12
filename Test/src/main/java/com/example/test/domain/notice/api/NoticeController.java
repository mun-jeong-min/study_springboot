package com.example.test.domain.notice.api;

import com.example.test.domain.notice.application.NoticeServicelmpl;
import com.example.test.domain.notice.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.dto.request.UpdateNoticeRequest;
import com.example.test.domain.notice.domain.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud")
public class NoticeController {

    private final NoticeServicelmpl noticeService;

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
    
    @PutMapping("/put/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody @Valid UpdateNoticeRequest request){
        return noticeService.update(id,request);
    }

    @DeleteMapping("/delete/{i}")
    public String delete(@PathVariable("i") Long id) {
        return noticeService.delete(id);
    }
}