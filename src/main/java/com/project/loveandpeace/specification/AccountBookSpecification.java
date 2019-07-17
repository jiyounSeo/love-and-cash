package com.project.loveandpeace.specification;

import com.project.loveandpeace.controller.accountBook.request.AccountBookSearchRequest;
import com.project.loveandpeace.domain.AccountBook;
import com.project.loveandpeace.domain.enumeration.AccountType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class AccountBookSpecification extends BaseSpecification<AccountBook, AccountBookSearchRequest>{
    private static String ACCOUNT_BOOK_TYPE = "type";

    @Override
    public Specification<AccountBook> getFilterForList(AccountBookSearchRequest request) {
        return (root, query, cb) ->
                where(typeEquals(request.getType()))
                        .toPredicate(root, query, cb);
    }

    private Specification<AccountBook> typeEquals(AccountType accountType) {
        return attributeEquals(ACCOUNT_BOOK_TYPE, accountType.toString());
    }
}
