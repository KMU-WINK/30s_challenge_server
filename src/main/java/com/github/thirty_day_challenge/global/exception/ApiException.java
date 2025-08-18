package com.github.thirty_day_challenge.global.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final String code;

    public ApiException(String code, String message) {

        super(message);
        this.code = code;
    }

    public ApiException(ApiExceptionCode code) {

        super(code.getMessage());
        this.code = code.getCode();
    }
}
