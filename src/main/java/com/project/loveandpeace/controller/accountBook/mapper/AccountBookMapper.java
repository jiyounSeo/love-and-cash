package com.project.loveandpeace.controller.accountBook.mapper;

import com.project.loveandpeace.common.enumeration.SaveState;
import com.project.loveandpeace.common.mapper.RequestEntityMapper;
import com.project.loveandpeace.controller.accountBook.request.AccountBookRequest;
import com.project.loveandpeace.controller.accountBook.result.AccountBookResult;
import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.repository.AccountBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountBookMapper implements RequestEntityMapper<AccountBookRequest, AccountBook> {
    private final AccountBookRepository accountBookRepository;

    public AccountBookResult entityToResult(AccountBook accountBook) {
        AccountBookResult accountBookResult = new AccountBookResult();
        accountBookResult.setTitle(accountBook.getTitle());
        accountBookResult.setType(accountBook.getType());
        accountBookResult.setIncomeCategory(accountBook.getIncomeCategory());
        accountBookResult.setOutgoingCategory(accountBook.getOutgoingCategory());
        accountBookResult.setPrice(accountBook.getPrice());
        accountBookResult.setDescription(accountBook.getDescription());
        accountBookResult.setUsingDate(accountBook.getUsingDate());
        accountBookResult.setObjectType(accountBook.getObjectType());
        return accountBookResult;
    }

    //https://dzone.com/articles/design-patterns-the-builder-pattern
    public Page<AccountBookResult> entityListToResultList(Page<AccountBook> entities, Pageable pageable) {
        List<AccountBookResult> accountBookResults = entities.stream().map(this::entityToResult).collect(Collectors.toList());

        return new PageImpl(accountBookResults, pageable, entities.getTotalElements());
    }

    @Override
    public AccountBook requestToEntity(SaveState state, AccountBookRequest request) {
        if (state == SaveState.NEW) {
            return requestToEntity(request);
        }

        return updateRequestToEntity(request);
    }

    public AccountBook requestToEntity(AccountBookRequest request) {
        return domainMapper(new AccountBook(), request);
    }

    public AccountBook updateRequestToEntity(AccountBookRequest request) {
        AccountBook accountBook = accountBookRepository.findById(request.getId()).orElseThrow(RuntimeException::new);
        return domainMapper(accountBook, request);
    }

    private AccountBook domainMapper(AccountBook accountBook, AccountBookRequest request) {
        accountBook.setTitle(request.getTitle());
        accountBook.setType(request.getType());
        accountBook.setOutgoingCategory(request.getOutgoingCategory());
        accountBook.setIncomeCategory(request.getIncomeCategory());
        accountBook.setPrice(request.getPrice());
        accountBook.setDescription(request.getDescription());
        accountBook.setUsingDate(request.getUsingDate());
        accountBook.setObjectType(request.getObjectType());
        return accountBook;
    }
}
