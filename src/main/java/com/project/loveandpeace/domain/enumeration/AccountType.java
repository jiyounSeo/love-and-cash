package com.project.loveandpeace.domain.enumeration;

public enum AccountType {
    INCOME(0, "수입"),
    OUTGOING(1, "지출");

    private Integer code;
    private String  description;

    AccountType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
