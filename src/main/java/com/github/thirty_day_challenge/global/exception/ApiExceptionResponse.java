package com.github.thirty_day_challenge.global.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ApiExceptionResponse {

    private String code;
    private String message;

    public static ApiExceptionResponse from(ApiException e) {

        return ApiExceptionResponse.of(e.getCode(), e.getMessage());
    }
}
