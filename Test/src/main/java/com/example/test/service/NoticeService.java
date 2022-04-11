package com.example.test.service;

import com.example.test.dto.request.CreateNoticeRequest;
import com.example.test.dto.request.UpdateNoticeRequest;
import com.example.test.entity.Notice;
import com.example.test.repository.NoticeRepository;
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
/*
    @Transactional
    public String update(Long id, UpdateNoticeRequest request) {
        noticeRepository.save(
                Notice.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .build()
        );

        return "update infomation";
    }
*/
    public String delete(Long id) {
        noticeRepository.deleteById(id);

        return "delete success";
    }
}