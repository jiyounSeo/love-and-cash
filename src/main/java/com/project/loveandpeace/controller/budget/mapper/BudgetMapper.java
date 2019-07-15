package com.project.loveandpeace.controller.budget.mapper;

import com.project.loveandpeace.controller.budget.request.BudgetRequest;
import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BudgetMapper {
    private final BudgetRepository budgetRepository;

    public Budget updateRequestToEntity(BudgetRequest budgetRequest) {
        Budget budget = budgetRepository.findByIdAndBudgetMonth(budgetRequest.getBudgetId(), budgetRequest.getBudgetMonth())
                .orElseThrow(RuntimeException::new);
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
}
