package com.project.loveandpeace.service;

import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.repository.AccountBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountBookService {

    private final AccountBookRepository accountBookRepository;

    public AccountBook registAccountBook(AccountBook accountBook) {
        //TODO :: validator
        return accountBookRepository.save(accountBook);
    }

    public AccountBook updateAccountBook(AccountBook accountBook) {
        //TODO :: validator
        return accountBookRepository.save(accountBook);
    }
}
