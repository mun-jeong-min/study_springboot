package com.example.test.service;

import com.example.test.dto.CreateNoticeRequest;
import com.example.test.entity.Notice;
import com.example.test.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> read(){
        return noticeRepository.findAll();
    }

    public String create(CreateNoticeRequest request) {
            noticeRepository.save(
                    Notice.builder()
                            .title(request.getTitle())
                            .content(request.getContent())
                            .build());

            return "create success";
    }
}