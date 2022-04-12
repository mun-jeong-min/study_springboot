package com.example.test.service;

import com.example.test.controller.dto.request.CreateNoticeRequest;
import com.example.test.controller.dto.request.UpdateNoticeRequest;
import com.example.test.domain.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> read();

    String create(CreateNoticeRequest request);

    String update(Long id, UpdateNoticeRequest request);

    String delete(Long id);
}
