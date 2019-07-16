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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "budget_id")
    private Budget budget;
    private OutgoingType outgoingType;
    private BigDecimal price;
    private String description;

    @Builder
    public BudgetDetail(Budget budget, OutgoingType outgoingType, BigDecimal price, String description) {
        this.budget = budget;
        this.outgoingType = outgoingType;
        this.price = price;
        this.description = description;
    }

}
