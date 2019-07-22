package com.project.loveandpeace.common.enumeration;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum RestApplicationType {

    SUCCESS_REQUEST("0000", HttpStatus.OK, "success"),
    NOT_FOUND_BUDGET("1000", HttpStatus.BAD_REQUEST , "not found budget"),
    NOT_FOUND_BUDGET_DETAIL("1001", HttpStatus.BAD_REQUEST , "not found budget detail")
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

    RestApplicationType(String code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
