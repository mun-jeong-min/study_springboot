package com.example.test.repository;

import com.example.test.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long>{
}