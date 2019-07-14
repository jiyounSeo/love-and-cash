package com.project.loveandpeace.controller.accountBook.request;

import com.project.loveandpeace.domain.enumeration.AccountType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountBookSearchRequest {
    private AccountType type;
}
