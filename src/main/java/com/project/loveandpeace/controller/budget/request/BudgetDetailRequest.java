package com.project.loveandpeace.controller.budget.request;

import com.project.loveandpeace.domain.enumeration.OutgoingType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BudgetDetailRequest {
    private Long budgetDetailId;
    private OutgoingType outgoingType;
    private BigDecimal price;
    private String description;
}
