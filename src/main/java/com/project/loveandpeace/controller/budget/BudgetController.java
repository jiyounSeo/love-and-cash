package com.project.loveandpeace.controller.budget;

import com.project.loveandpeace.controller.budget.mapper.BudgetDetailMapper;
import com.project.loveandpeace.controller.budget.mapper.BudgetMapper;
import com.project.loveandpeace.controller.budget.request.BudgetDetailRequest;
import com.project.loveandpeace.controller.budget.request.BudgetDetailResult;
import com.project.loveandpeace.controller.budget.request.BudgetRequest;
import com.project.loveandpeace.controller.budget.result.BudgetResponse;
import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.domain.BudgetDetail;
import com.project.loveandpeace.repository.BudgetDetailRepository;
import com.project.loveandpeace.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/budget")
public class BudgetController {

    private final BudgetMapper budgetMapper;
    private final BudgetRepository budgetRepository;
    private final BudgetDetailMapper budgetDetailMapper;
    private final BudgetDetailRepository budgetDetailRepository;

    @PostMapping
    public Budget createBudget(@RequestBody BudgetRequest budgetRequest) {
        Budget budget = budgetMapper.requestToEntity(budgetRequest);
        return budgetRepository.save(budget);
    }

    @PutMapping
    public Budget updateBudget(@RequestBody BudgetRequest budgetRequest) {
        Budget budget = budgetMapper.updateRequestToEntity(budgetRequest);
        return budgetRepository.save(budget);
    }

    @PostMapping("{budgetId}/budgetDetail")
    public BudgetDetailResult createBudgetDetail(@PathVariable Long budgetId, @RequestBody BudgetDetailRequest budgetDetailRequest) {
        BudgetDetail budgetDetail = budgetDetailMapper.requestToEntity(budgetId, budgetDetailRequest);
        budgetDetailRepository.save(budgetDetail);
        return budgetDetailMapper.entityToResponse(budgetDetail);
    }

    @PutMapping("{budgetId}/budgetDetail")
    public BudgetDetail updateBudgetDetail(@PathVariable Long budgetId, @RequestBody BudgetDetailRequest budgetDetailRequest) {
        BudgetDetail budgetDetail = budgetDetailMapper.updateRequestToEntity(budgetId, budgetDetailRequest);
        return budgetDetailRepository.save(budgetDetail);
    }

    @GetMapping("{budgetId}")
    public BudgetResponse getBudget(@PathVariable Long budgetId) {
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(RuntimeException::new);
        return budgetMapper.entityToResponse(budget);

    }


}
