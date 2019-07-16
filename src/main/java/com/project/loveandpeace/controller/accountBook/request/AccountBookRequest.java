package com.project.loveandpeace.controller.accountBook.request;

import com.project.loveandpeace.domain.enumeration.AccountType;
import com.project.loveandpeace.domain.enumeration.OutgoingCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBookRequest {
    private Long id;
    private String title;
    private AccountType type;
    private OutgoingCategory category;
    private BigDecimal price;
    private String description;
    private String usingDate;
}
