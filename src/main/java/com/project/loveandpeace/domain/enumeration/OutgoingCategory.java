package com.project.loveandpeace.domain.enumeration;

public enum OutgoingCategory implements AccountCategory{
    FOOD(0,"식비"),
    ALCOHOL(1,"술"),
    BEVERAGE(2,"음료"),
    TRANSPORT(3,"교통"),
    OILING(4,"주유"),
    CULTURE(5,"문화생활"),
    MART(6,"마트/편의점"),
    FASHION(7,"패션/미용"),
    HOUSEHOLD_ITEM(8,"생활용품"),
    HOUSING_COMMUNICATION(9,"주거/통신"),
    HEALTH(10,"의료/건강"),
    EDUCATION(11,"교육"),
    DUES(12,"경조사/회비"),
    INSURANCE(13,"보험"),
    PARENT(14,"부모님"),
    CARD(15,"카드"),
    DATING(16,"데이트"),
    TAX(17,"세금"),
    DONATE(18, "기부금"),
    TRAVEL(19, "여행"),
    WITHDRAW(20, "출금"),
    ETC(99,"기타")
    ;

    private Integer code;
    private String description;

    OutgoingCategory(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
