package com.project.loveandpeace.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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


    @Builder
    public Budget(String budgetMonth, BigDecimal price, String description) {
        this.budgetMonth = budgetMonth;
        this.price = price;
        this.description = description;
    }


}
