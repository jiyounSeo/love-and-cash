package com.project.loveandpeace.domain;

import com.project.loveandpeace.domain.enumeration.OutgoingType;
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
public class BudgetDetail {

    @Id
    @Column(name="budget_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long budgetId;
    private OutgoingType outgoingType;
    private BigDecimal price;
    private String description;

    @Builder
    public BudgetDetail(Long budgetId, OutgoingType outgoingType, BigDecimal price, String description) {
        this.budgetId = budgetId;
        this.outgoingType = outgoingType;
        this.price = price;
        this.description = description;
    }

}