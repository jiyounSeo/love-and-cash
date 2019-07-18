package com.project.loveandpeace.controller.budget.result;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetResponse {
    private Long id;
    private String budgetMonth;
    private BigDecimal price;
    private String description;
}
