package com.github.thirty_day_challenge.global.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({NoResourceFoundException.class, HttpRequestMethodNotSupportedException.class})
    public ApiExceptionResponse noResourceFoundException() {

        return ApiExceptionResponse.of("GLOBAL_001", "요청하신 리소스를 찾을 수 없습니다.");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiExceptionResponse httpMessageNotReadableException() {

        return ApiExceptionResponse.of("GLOBAL_002", "요청 데이터가 올바르지 않습니다.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiExceptionResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {

        if (Objects.isNull(e.getBindingResult().getFieldError())) {

            return ApiExceptionResponse.of("GLOBAL_003", e.getMessage());
        }

        String field = e.getBindingResult().getFieldError().getField();
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        String errorMessage = String.format("%s은(는) %s", field, message);

        return ApiExceptionResponse.of("GLOBAL_005", errorMessage);
    }

    @ExceptionHandler(ApiException.class)
    public ApiExceptionResponse apiException(ApiException e) {

        return ApiExceptionResponse.from(e);
    }

    @ExceptionHandler(Exception.class)
    public ApiExceptionResponse exception(Exception e) {

        log.error("", e);

        return ApiExceptionResponse.of("GLOBAL_005", "알 수 없는 오류가 발생했습니다.");
    }
}
