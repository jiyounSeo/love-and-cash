package com.project.loveandpeace.exception;

import com.project.loveandpeace.common.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RestResponse handler(Exception ex) {
        return new RestResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(RestException.class)
    public RestResponse handler(RestException restException) {
        return new RestResponse(restException.getRestApplicationType());
    }


}
