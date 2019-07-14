package com.project.loveandpeace.controller.accountBook;

import com.project.loveandpeace.controller.accountBook.mapper.AccountBookMapper;
import com.project.loveandpeace.controller.accountBook.request.AccountBookRequest;
import com.project.loveandpeace.controller.accountBook.request.AccountBookSearchRequest;
import com.project.loveandpeace.controller.accountBook.result.AccountBookResult;
import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.service.AccountBookService;
import com.project.loveandpeace.specification.AccountBookSpecification;
import com.project.loveandpeace.repository.AccountBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/accountBook")
@RestController
@RequiredArgsConstructor
public class AccountBookController {

    private final AccountBookRepository accountBookRepository;
    private final AccountBookMapper accountBookMapper;
    private final AccountBookSpecification accountBookSpecification;
    private final AccountBookService accountBookService;

    @GetMapping
    public Page<AccountBookResult> accountBookList(@PageableDefault(
            sort = {"createDt"},
            direction = Sort.Direction.DESC) Pageable pageable, AccountBookSearchRequest request) {
        Page<AccountBook> accountBooks = accountBookRepository.findAll(accountBookSpecification.getFilterForList(request),pageable);
        return accountBookMapper.entityListToResultList(accountBooks, pageable);
    }

    @PostMapping
    public AccountBookResult registAccountBook(@RequestBody AccountBookRequest request) {
        AccountBook accountBook = accountBookService.registAccountBook(accountBookMapper.requestToEntity(request));
        return accountBookMapper.entityToResult(accountBook);
    }

    @PutMapping
    public AccountBookResult updateAccountBook(@RequestBody AccountBookRequest request) {
        AccountBook accountBook = accountBookService.updateAccountBook(accountBookMapper.requestToEntity(request));
        return accountBookMapper.entityToResult(accountBook);
    }
}
