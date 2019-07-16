package com.project.loveandpeace.repository;

import com.project.loveandpeace.domain.AccountBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AccountBookRepository extends JpaRepository<AccountBook, Long>, JpaSpecificationExecutor<AccountBook> {
    Page<AccountBook> findAll(Pageable pageable);
}
