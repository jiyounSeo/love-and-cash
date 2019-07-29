package com.project.loveandpeace.controller.budget.mapper;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import com.project.loveandpeace.controller.budget.request.BudgetRequest;
import com.project.loveandpeace.controller.budget.result.BudgetResponse;
import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.exception.RestException;
import com.project.loveandpeace.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BudgetMapper {
    private final BudgetRepository budgetRepository;
    private final BudgetDetailMapper budgetDetailMapper;


    public Budget updateRequestToEntity(BudgetRequest budgetRequest) {
        Budget budget = budgetRepository.findByIdAndBudgetMonth(budgetRequest.getBudgetId(), budgetRequest.getBudgetMonth())
                .orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET));
        budget.setPrice(budgetRequest.getPrice());
        budget.setDescription(budgetRequest.getDescription());
        return budget;
    }

    public Budget requestToEntity(BudgetRequest budgetRequest) {
        return Budget.builder()
                .price(budgetRequest.getPrice())
                .budgetMonth(budgetRequest.getBudgetMonth())
                .description(budgetRequest.getDescription())
                .build();
    }

    public BudgetResponse entityToResponse(Budget budget) {
        BudgetResponse budgetResponse = new BudgetResponse();
        budgetResponse.setBudgetMonth(budget.getBudgetMonth());
        budgetResponse.setDescription(budget.getDescription());
        budgetResponse.setPrice(budget.getPrice());
        budgetResponse.setBudgetDetails(budget.getBudgetDetails().stream().map(budgetDetailMapper::entityToResponse).collect(Collectors.toList()));
        return budgetResponse;

    }
}
