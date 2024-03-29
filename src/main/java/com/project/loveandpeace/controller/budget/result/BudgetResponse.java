package com.project.loveandpeace.controller.budget.result;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BudgetResponse {
    private Long id;
    private String budgetMonth;
    private BigDecimal price;
    private String description;
    private List<BudgetDetailResponse> budgetDetails;
}
