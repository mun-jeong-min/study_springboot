package com.example.test.domain.notice.application;

import com.example.test.domain.notice.application.NoticeService;
import com.example.test.domain.notice.domain.Notice;
import com.example.test.domain.notice.dto.request.CreateNoticeRequest;
import com.example.test.domain.notice.dto.request.UpdateNoticeRequest;
import com.example.test.domain.notice.dao.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoticeServicelmpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public List<Notice> read(){
        return noticeRepository.findAll();
    }

    @Override
    public String create(CreateNoticeRequest request) {
            noticeRepository.save(
                    Notice.builder()
                            .title(request.getTitle())
                            .content(request.getContent())
                            .build());

            return "create success";
    }

    @Transactional
    @Override
    public String update(Long id, UpdateNoticeRequest request) {
        Optional<Notice> notice = noticeRepository.findById(id);

        notice.get().setTitle(request.getTitle());
        notice.get().setContent(request.getContent());

        return "update success";
    }

    @Override
    public String delete(Long id) {
        noticeRepository.deleteById(id);

        return "delete success";
    }
}