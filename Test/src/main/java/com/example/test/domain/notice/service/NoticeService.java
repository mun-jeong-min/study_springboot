package com.example.test.domain.notice.service;

import com.example.test.domain.notice.domain.repository.NoticeRepository;
import com.example.test.domain.notice.domain.Notice;
import com.example.test.domain.notice.present.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.present.dto.request.UpdateNoticeRequest;
import com.example.test.domain.notice.exception.NoticeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service

public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> read() {
        return noticeRepository.findAll();
    }

    public Notice readOne(Long id) {
        return noticeRepository.findNoticeById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);
    }

    public void create(CreateNoticeRequest request) {
        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build());
    }

    @Transactional
    public void update(Long id, UpdateNoticeRequest request) {
        Notice notice = noticeRepository.findNoticeById(id)
                .orElseThrow(() -> NoticeNotFoundException.EXCEPTION);

        notice.updateNotice(request.getTitle(), request.getContent());
    }

    @Transactional
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}
