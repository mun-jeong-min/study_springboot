package com.example.test.domain.notice.application;

import com.example.test.domain.notice.dao.NoticeRepository;
import com.example.test.domain.notice.domain.Notice;
import com.example.test.domain.notice.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.dto.request.UpdateNoticeRequest;
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

        notice.setTitle(request.getTitle());
        notice.setContent(request.getContent());
    }

    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}
