package com.project.loveandpeace.controller.budget.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetRequest {
    private Long budgetId;
    private String budgetMonth;
    private BigDecimal price;
    private String description;
}
