package com.project.loveandpeace.controller.budget;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import com.project.loveandpeace.controller.budget.mapper.BudgetDetailMapper;
import com.project.loveandpeace.controller.budget.mapper.BudgetMapper;
import com.project.loveandpeace.controller.budget.request.BudgetDetailRequest;
import com.project.loveandpeace.controller.budget.request.BudgetRequest;
import com.project.loveandpeace.controller.budget.result.BudgetDetailResponse;
import com.project.loveandpeace.controller.budget.result.BudgetResponse;
import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.domain.BudgetDetail;
import com.project.loveandpeace.exception.RestException;
import com.project.loveandpeace.repository.BudgetDetailRepository;
import com.project.loveandpeace.repository.BudgetRepository;
import com.project.loveandpeace.service.BudgetService;
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
    private final BudgetService budgetService;

    @PostMapping
    public BudgetResponse createBudget(@RequestBody BudgetRequest budgetRequest) {
        Budget budget = budgetMapper.requestToEntity(budgetRequest);
        return budgetMapper.entityToResponse(budgetRepository.save(budget));
    }

    @PutMapping
    public BudgetResponse updateBudget(@RequestBody BudgetRequest budgetRequest) {
        Budget budget = budgetMapper.updateRequestToEntity(budgetRequest);
        return budgetMapper.entityToResponse(budgetRepository.save(budget));
    }

    @PostMapping("{budgetId}/budgetDetail")
    public BudgetDetailResponse createBudgetDetail(@PathVariable Long budgetId, @RequestBody BudgetDetailRequest budgetDetailRequest) {
        BudgetDetail budgetDetail = budgetDetailMapper.requestToEntity(budgetId, budgetDetailRequest);
        budgetDetailRepository.save(budgetDetail);
        return budgetDetailMapper.entityToResponse(budgetDetail);
    }

    @PutMapping("{budgetId}/budgetDetail")
    public BudgetDetailResponse updateBudgetDetail(@PathVariable Long budgetId, @RequestBody BudgetDetailRequest budgetDetailRequest) {
        BudgetDetail budgetDetail = budgetDetailMapper.updateRequestToEntity(budgetId, budgetDetailRequest);
        budgetService.checkBudgetLimit(budgetDetail);
        budgetDetailRepository.save(budgetDetail);
        return budgetDetailMapper.entityToResponse(budgetDetail);
    }

    @GetMapping("{budgetId}")
    public BudgetResponse getBudget(@PathVariable Long budgetId) {
        Budget budget = budgetRepository.findById(budgetId).orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET));
        return budgetMapper.entityToResponse(budget);
    }

    @GetMapping("budgetDetail/{budgetDetailId}")
    public BudgetDetailResponse getBudgetDetail(@PathVariable Long budgetDetailId) {
        BudgetDetail budgetDetail = budgetDetailRepository.findById(budgetDetailId).orElseThrow(() -> new RestException(RestApplicationType.NOT_FOUND_BUDGET_DETAIL));
        return budgetDetailMapper.entityToResponse(budgetDetail);
    }



}
