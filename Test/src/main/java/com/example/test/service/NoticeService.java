package com.example.test.service;

import com.example.test.controller.dto.request.CreateNoticeRequest;
import com.example.test.controller.dto.request.UpdateNoticeRequest;
import com.example.test.domain.Notice;
import com.example.test.domain.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> read(){
        return noticeRepository.findAll();
    }

    public String create(CreateNoticeRequest post) {
            noticeRepository.save(
                    Notice.builder()
                            .title(post.getTitle())
                            .content(post.getContent())
                            .build());

            return "create success";
    }

    @Transactional
    public String update(Long id, UpdateNoticeRequest request) {
        Optional<Notice> notice = noticeRepository.findById(id);

        notice.get().setTitle(request.getTitle());
        notice.get().setContent(request.getContent());

        return "update success";
    }

    public String delete(Long id) {
        noticeRepository.deleteById(id);

        return "delete success";
    }
}