package com.project.loveandpeace.repository;

import com.project.loveandpeace.domain.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Optional;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Optional<Budget> findByIdAndBudgetMonth(Long id, String budgetMonth);
}
