package com.project.loveandpeace.domain.enumeration;

public enum  ObjectType {
    MAN(0, "남자"),
    WOMAN(1, "여자"),
    COMMON(2, "공동");

    private Integer code;
    private String  description;

    ObjectType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
