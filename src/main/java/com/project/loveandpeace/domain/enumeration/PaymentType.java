package com.project.loveandpeace.domain.enumeration;

public enum PaymentType {
    CASH(0,"현금"),
    CASH_CARD(1,"체크카드"),
    CREDIT_CARD(2,"신용카드"),
    GIFT_CARD(3,"상품권");

    private Integer code;
    private String description;

    PaymentType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
