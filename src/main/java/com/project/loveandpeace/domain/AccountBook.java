package com.project.loveandpeace.domain;

import com.project.loveandpeace.domain.enumeration.AccountType;
import com.project.loveandpeace.domain.enumeration.AccountCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountBook extends BaseTimeEntity{

    private Long id;
    private String title;
    private AccountType type;
    private AccountCategory category;
    private BigDecimal price;
    private String description;
    private String usingDate;

    //TODO :: 사용자 타입 추가 (남, 녀 공용)
}
