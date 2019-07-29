package com.project.loveandpeace.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Budget {

    @Id
    @Column(name="budget_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String budgetMonth;
    private BigDecimal price;
    private String description;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<BudgetDetail> budgetDetails = new ArrayList<>();


    @Builder
    public Budget(String budgetMonth, BigDecimal price, String description) {
        this.budgetMonth = budgetMonth;
        this.price = price;
        this.description = description;
    }


}
