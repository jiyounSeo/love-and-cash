package com.project.loveandpeace.repository;

import com.project.loveandpeace.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
