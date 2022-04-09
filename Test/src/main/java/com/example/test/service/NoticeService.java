package com.example.test.service;

import com.example.test.dto.CreateNoticeRequest;
import com.example.test.entity.Notice;
import com.example.test.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class NoticeService {

    private final NoticeRepository noticeRepository;

    @Transactional
    public void create(CreateNoticeRequest request) {
            noticeRepository.save(
                    Notice.builder()
                            .title(request.getTitle())
                            .content(request.getContent())
                            .build());
    }

    public void read() {
        noticeRepository.findAll();
    }
}
