package com.project.loveandpeace.domain.enumeration;

public enum  ClassificationType {
    INCOME(0, "수입"),
    OUTGOING(1, "지출");

    private Integer code;
    private String  description;

    ClassificationType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
