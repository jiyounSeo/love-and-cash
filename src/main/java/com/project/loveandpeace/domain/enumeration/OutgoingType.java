package com.project.loveandpeace.domain.enumeration;

public enum OutgoingType {
    FOOD(0,"식비"),
    ALCOHOL(1,"술"),
    BEVERAGE(2,"음료"),
    TRANSPORT(3,"교통/차량"),
    CULTURE(4,"문화생활"),
    MART(5,"마트/편의점"),
    FASHION(6,"패션/미용"),
    HOUSEHOLD_ITEM(7,"생활용품"),
    HOUSING_COMMUNICATION(8,"주거/통신"),
    HEALTH(9,"건강"),
    EDUCATION(10,"교육"),
    DUES(11,"경조사/회비"),
    INSURANCE(12,"보험"),
    PARENT(13,"부모님"),
    CARD(14,"카드"),
    DATING(15,"데이트"),
    TAX(16,"세금"),
    ETC(17,"기타")
    ;

    private Integer code;
    private String description;

    OutgoingType(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
