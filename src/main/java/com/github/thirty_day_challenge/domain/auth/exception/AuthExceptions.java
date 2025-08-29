package com.github.thirty_day_challenge.domain.auth.exception;

import com.github.thirty_day_challenge.global.exception.ApiExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthExceptions implements ApiExceptionCode {

    AUTHENTICATION_FAILED("AUTH_001", "인증을 실패했습니다."),
    ;

    private final String code;
    private final String message;
}
