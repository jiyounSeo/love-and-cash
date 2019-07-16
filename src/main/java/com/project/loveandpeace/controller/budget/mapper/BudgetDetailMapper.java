package com.project.loveandpeace.controller.budget.mapper;

import com.project.loveandpeace.controller.budget.request.BudgetDetailRequest;
import com.project.loveandpeace.controller.budget.request.BudgetDetailResult;
import com.project.loveandpeace.domain.Budget;
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
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(RuntimeException::new);
        return BudgetDetail.builder().budget(budget)
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

    public BudgetDetailResult entityToResponse(BudgetDetail budgetDetail) {
        BudgetDetailResult result = new BudgetDetailResult();
        result.setBudgetDetailId(budgetDetail.getId());
        result.setBudgetId(budgetDetail.getBudget().getId());
        return result;

    }
}
