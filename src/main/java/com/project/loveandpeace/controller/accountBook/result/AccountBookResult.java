package com.project.loveandpeace.controller.accountBook.result;

import com.project.loveandpeace.domain.enumeration.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBookResult {
    private String title;
    private AccountType type;
    private IncomeCategory incomeCategory;
    private OutgoingCategory outgoingCategory;
    private BigDecimal price;
    private String description;
    private String usingDate;
    private ObjectType objectType;
}
