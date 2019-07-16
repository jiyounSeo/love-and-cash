package com.project.loveandpeace.domain;

import com.project.loveandpeace.domain.enumeration.AccountType;
import com.project.loveandpeace.domain.enumeration.AccountCategory;
import com.project.loveandpeace.domain.enumeration.ObjectType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class AccountBook extends BaseTimeEntity{

    @Id
    @Column(name="account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private AccountType type;
    private AccountCategory category;
    private BigDecimal price;
    private String description;
    private String usingDate;

    //TODO :: 사용자 타입 추가 (남, 녀 공용)
    private ObjectType objectType;
}
