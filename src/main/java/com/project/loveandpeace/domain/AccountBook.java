package com.project.loveandpeace.domain;

import com.project.loveandpeace.domain.enumeration.AccountType;
import com.project.loveandpeace.domain.enumeration.IncomeCategory;
import com.project.loveandpeace.domain.enumeration.ObjectType;
import com.project.loveandpeace.domain.enumeration.OutgoingCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class AccountBook {

    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private AccountType type;
    private IncomeCategory incomeCategory;
    private OutgoingCategory outgoingCategory;
    private BigDecimal price;
    private String description;
    private String usingDate;

    //TODO :: 직관적인 네이밍 없을 까요? .. (paymentType..?)
    private ObjectType objectType;

    /*
    @Builder
    public AccountBook(String title, AccountType type, IncomeCategory incomeCategory, OutgoingCategory outgoingCategory, BigDecimal price, String description, String usingDate) {
        this.title = title;
        this.type = type;
        this.incomeCategory = incomeCategory;
        this.outgoingCategory = outgoingCategory;
        this.price = price;
        this.description = description;
        this.usingDate = usingDate;
    }
    */
}
