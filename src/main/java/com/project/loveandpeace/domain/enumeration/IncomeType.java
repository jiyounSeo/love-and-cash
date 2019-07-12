package com.project.loveandpeace.domain.enumeration;

public enum IncomeType {
    SALARY(0, "월급"),
    ADDITIONAL_INCOME(1, "부수입"),
    POCKET_MONEY(2, "용돈"),
    BONUS(3, "상여"),
    FINANCE(4, "금융소득"),
    ETC(5, "기타")
    ;

    private Integer code;
    private String  description;

    IncomeType(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
