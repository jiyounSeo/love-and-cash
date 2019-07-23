package com.project.loveandpeace.domain.enumeration;

public enum IncomeCategory implements AccountCategory {
    SALARY(0, "월급"),
    ADDITIONAL_INCOME(1, "부수입"),
    POCKET_MONEY(2, "용돈"),
    BONUS(3, "상여"),
    FINANCE(4, "금융소득"),
    GIFT_CARD(5, "상품권"),
    INSURANCE(6, "보험비"),
    ETC(99, "기타")
    ;

    private Integer code;
    private String  description;

    IncomeCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
