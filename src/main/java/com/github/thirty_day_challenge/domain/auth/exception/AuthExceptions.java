package com.github.thirty_day_challenge.domain.auth.exception;

import com.github.thirty_day_challenge.global.exception.ApiExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthExceptions implements ApiExceptionCode {

    NOT_EQUAL_PASSWORD("AUTH_001", "비밀번호가 일치하지 않습니다."),
    ;

    private final String code;
    private final String message;
}
