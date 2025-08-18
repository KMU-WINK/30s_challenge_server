package com.github.thirty_day_challenge.global.exception;

public interface ApiExceptionCode {

    String getCode();

    String getMessage();

    default ApiException toException() {

        return new ApiException(this);
    }
}
