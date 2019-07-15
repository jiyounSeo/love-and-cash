package com.project.loveandpeace.controller.budget.mapper;

import com.project.loveandpeace.controller.budget.request.BudgetDetailRequest;
import com.project.loveandpeace.domain.BudgetDetail;
import com.project.loveandpeace.repository.BudgetDetailRepository;
import com.project.loveandpeace.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BudgetDetailMapper {
    private final BudgetRepository budgetRepository;
    private final BudgetDetailRepository budgetDetailRepository;

    public BudgetDetail requestToEntity(Long budgetId, BudgetDetailRequest budgetDetailRequest) {
        budgetRepository.findById(budgetId).orElseThrow(RuntimeException::new);
        return BudgetDetail.builder().budgetId(budgetId)
                .description(budgetDetailRequest.getDescription())
                .outgoingType(budgetDetailRequest.getOutgoingType())
                .price(budgetDetailRequest.getPrice())
                .build();
    }

    public BudgetDetail updateRequestToEntity(Long budgetId, BudgetDetailRequest budgetDetailRequest) {
        budgetRepository.findById(budgetId).orElseThrow(RuntimeException::new);
        BudgetDetail budgetDetail = budgetDetailRepository.findById(budgetDetailRequest.getBudgetDetailId())
                .orElseThrow(RuntimeException::new);
        budgetDetail.setPrice(budgetDetailRequest.getPrice());
        budgetDetail.setDescription(budgetDetailRequest.getDescription());
        budgetDetail.setOutgoingType(budgetDetail.getOutgoingType());
        return budgetDetail;

    }
}
