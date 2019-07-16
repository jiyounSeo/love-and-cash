package com.project.loveandpeace.controller.accountBook.request;

import com.project.loveandpeace.domain.enumeration.AccountCategory;
import com.project.loveandpeace.domain.enumeration.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBookRequest {
    private Long id;
    private String title;
    private AccountType type;
    private AccountCategory category;
    private BigDecimal price;
    private String description;
    private String usingDate;
}
