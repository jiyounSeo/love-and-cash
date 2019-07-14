package com.project.loveandpeace.repository;

import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.domain.enumeration.AccountType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.print.Pageable;
import java.util.List;

public interface AccountBookRepository extends JpaRepository<AccountBook, Long>, JpaSpecificationExecutor<AccountBook> {
    Page<AccountBook> findAll(Pageable pageable);
    List<AccountBook> findAllByType(AccountType type);
}
