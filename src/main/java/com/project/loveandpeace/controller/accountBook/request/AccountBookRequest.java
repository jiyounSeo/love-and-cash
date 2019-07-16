package com.project.loveandpeace.controller.accountBook.request;

import com.project.loveandpeace.domain.enumeration.AccountType;
import com.project.loveandpeace.domain.enumeration.IncomeCategory;
import com.project.loveandpeace.domain.enumeration.ObjectType;
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
    private IncomeCategory incomeCategory;
    private OutgoingCategory outgoingCategory;
    private BigDecimal price;
    private String description;
    private String usingDate;
    private ObjectType objectType;
}
