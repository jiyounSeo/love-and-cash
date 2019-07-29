package com.project.loveandpeace.controller.budget.mapper;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import com.project.loveandpeace.controller.budget.request.BudgetDetailRequest;
import com.project.loveandpeace.controller.budget.result.BudgetDetailResponse;
import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.domain.BudgetDetail;
import com.project.loveandpeace.exception.RestException;
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
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET));
        return BudgetDetail.builder().budget(budget)
                .description(budgetDetailRequest.getDescription())
                .outgoingCategory(budgetDetailRequest.getOutgoingCategory())
                .price(budgetDetailRequest.getPrice())
                .build();
    }

    public BudgetDetail updateRequestToEntity(Long budgetId, BudgetDetailRequest budgetDetailRequest) {
        budgetRepository.findById(budgetId).orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET));
        BudgetDetail budgetDetail = budgetDetailRepository.findById(budgetDetailRequest.getBudgetDetailId())
                .orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET_DETAIL));
        budgetDetail.setPrice(budgetDetailRequest.getPrice());
        budgetDetail.setDescription(budgetDetailRequest.getDescription());
        budgetDetail.setOutgoingCategory(budgetDetailRequest.getOutgoingCategory());
        return budgetDetail;

    }

    public BudgetDetailResponse entityToResponse(BudgetDetail budgetDetail) {
        BudgetDetailResponse result = new BudgetDetailResponse();
        result.setBudgetId(budgetDetail.getBudget().getId());
        result.setBudgetDetailId(budgetDetail.getId());
        result.setDescription(budgetDetail.getDescription());
        result.setOutgoingCategory(budgetDetail.getOutgoingCategory());
        result.setPrice(budgetDetail.getPrice());
        return result;

    }
}
