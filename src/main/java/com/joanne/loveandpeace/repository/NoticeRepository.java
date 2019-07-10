package com.joanne.loveandpeace.repository;

import com.joanne.loveandpeace.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
