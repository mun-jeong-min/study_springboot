package com.example.test.domain.notice.application;

import com.example.test.domain.notice.domain.Notice;
import com.example.test.domain.notice.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.dto.request.UpdateNoticeRequest;

import java.util.List;

public interface NoticeService {
    List<Notice> read();

    String create(CreateNoticeRequest request);

    String update(Long id, UpdateNoticeRequest request);

    String delete(Long id);
}
