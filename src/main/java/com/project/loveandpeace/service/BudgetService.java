package com.project.loveandpeace.service;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import com.project.loveandpeace.domain.BudgetDetail;
import com.project.loveandpeace.exception.RestException;
import com.project.loveandpeace.repository.BudgetDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetService {
    private final BudgetDetailRepository budgetDetailRepository;

    public void checkBudgetLimit(BudgetDetail budgetDetail) {
        List<BudgetDetail> budgetDetails = budgetDetailRepository.findAllByBudget(budgetDetail.getBudget());
        BigDecimal sum = budgetDetail.getPrice();
        for (BudgetDetail detail : budgetDetails) {
            BigDecimal price = detail.getPrice();
            sum.add(price);
        }
        if (budgetDetail.getBudget().getPrice().compareTo(sum) != 1) {
            throw new RestException(RestApplicationType.BUDGET_LIMIT_OVER);
        }
    }
}
