package com.project.loveandpeace.controller.accountBook.mapper;

import com.project.loveandpeace.controller.accountBook.request.AccountBookRequest;
import com.project.loveandpeace.controller.accountBook.result.AccountBookResult;
import com.project.loveandpeace.domain.AccountBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class AccountBookMapper {
    public AccountBookResult entityToResult(AccountBook accountBook) {
        AccountBookResult accountBookResult = new AccountBookResult();
        accountBookResult.setTitle(accountBook.getTitle());
        accountBookResult.setType(accountBook.getType());
        accountBookResult.setCategory(accountBook.getCategory());
        accountBookResult.setPrice(accountBook.getPrice());
        accountBookResult.setDescription(accountBook.getDescription());
        accountBookResult.setUsingDate(accountBook.getUsingDate());

        return accountBookResult;
    }

    //https://dzone.com/articles/design-patterns-the-builder-pattern
    public Page<AccountBookResult> entityListToResultList(Page<AccountBook> entities, Pageable pageable) {
        List<AccountBookResult> accountBookResults = entities.stream().map(this::entityToResult).collect(Collectors.toList());

        return new PageImpl(accountBookResults, pageable, entities.getTotalElements());
    }

    public AccountBook requestToEntity(AccountBookRequest request) {
        AccountBook accountBook = new AccountBook();
        accountBook.setTitle(request.getTitle());
        accountBook.setType(request.getType());
        accountBook.setCategory(request.getCategory());
        accountBook.setPrice(request.getPrice());
        accountBook.setDescription(request.getDescription());
        accountBook.setUsingDate(request.getUsingDate());

        return accountBook;
    }
}
