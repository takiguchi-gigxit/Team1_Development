package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
