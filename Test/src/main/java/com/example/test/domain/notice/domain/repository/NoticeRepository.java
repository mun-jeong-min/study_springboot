package com.example.test.domain.notice.domain.repository;

import com.example.test.domain.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findNoticeById(Long id);
}