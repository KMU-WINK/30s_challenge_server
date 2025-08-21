package com.github.thirty_day_challenge.domain.auth.exception;

import com.github.thirty_day_challenge.global.exception.ApiExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthExceptions implements ApiExceptionCode {

    NOT_EQUAL_PASSWORD("AUTH_001", "비밀번호가 일치하지 않습니다."),
    AUTHENTICATION_FAILED("AUTH_002", "인증을 실패했습니다."),
    INVALID_SESSION("AUTH_003", "유효하지 않은 세션입니다."),
    ;

    private final String code;
    private final String message;
}
