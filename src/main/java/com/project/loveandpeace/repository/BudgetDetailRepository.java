package com.project.loveandpeace.repository;

import com.project.loveandpeace.domain.Budget;
import com.project.loveandpeace.domain.BudgetDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetDetailRepository extends JpaRepository<BudgetDetail, Long> {
    List<BudgetDetail> findAllByBudget(Budget budget);
}
