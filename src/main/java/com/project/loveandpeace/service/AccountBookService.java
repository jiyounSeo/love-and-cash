package com.project.loveandpeace.service;

import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.repository.AccountBookRepository;
import com.project.loveandpeace.validator.AccountBookValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;

import static com.project.loveandpeace.common.enumeration.SaveState.UPDATE;

@Service
@RequiredArgsConstructor
public class AccountBookService {

    private final AccountBookRepository accountBookRepository;
    private final AccountBookValidator accountBookValidator;

    public AccountBook registAccountBook(AccountBook accountBook) {
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(accountBook, AccountBook.class.getSimpleName());
        accountBookValidator.validate(accountBook, errors);
        return accountBookRepository.save(accountBook);
    }

    public AccountBook updateAccountBook(AccountBook accountBook) {
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(accountBook, AccountBook.class.getSimpleName());
        accountBookValidator.validate(UPDATE, accountBook, errors);
        return accountBookRepository.save(accountBook);
    }
}
