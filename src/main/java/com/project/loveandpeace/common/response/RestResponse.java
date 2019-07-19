package com.project.loveandpeace.common.response;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestResponse {
    private String code;
    private HttpStatus status;
    private String message;
    private Object response;

    public RestResponse(HttpStatus httpStatus) {
        this.status = httpStatus;
    }

    public RestResponse(RestApplicationType restApplicationType) {
        this.code = restApplicationType.getCode();
        this.status = restApplicationType.getHttpStatus();
        this.message = restApplicationType.getMessage();
    }
}
