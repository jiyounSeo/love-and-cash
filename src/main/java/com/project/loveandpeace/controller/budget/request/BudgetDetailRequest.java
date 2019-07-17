package com.project.loveandpeace.controller.budget.request;

import com.project.loveandpeace.domain.enumeration.OutgoingCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetDetailRequest {
    private Long budgetDetailId;
    private OutgoingCategory outgoingCategory;
    private BigDecimal price;
    private String description;
}
