package com.github.thirty_day_challenge.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ApiExceptionResponse {

    private String errorMessage;

    public static ApiExceptionResponse from(ApiException apiException) {

        return ApiExceptionResponse.of(apiException.getMessage());
    }
}
