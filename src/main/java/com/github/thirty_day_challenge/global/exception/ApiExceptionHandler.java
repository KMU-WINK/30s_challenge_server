package com.github.thirty_day_challenge.global.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ApiExceptionResponse apiException(ApiException e) {

        return ApiExceptionResponse.from(e);
    }
}
