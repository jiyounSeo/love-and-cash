package com.project.loveandpeace.exception;

import com.project.loveandpeace.common.enumeration.RestApplicationType;
import lombok.Getter;

@Getter
public class RestException extends RuntimeException {
    private RestApplicationType restApplicationType;

    public RestException(RestApplicationType restApplicationType) {
        this.restApplicationType = restApplicationType;
    }
}
