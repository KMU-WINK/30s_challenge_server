package com.github.thirty_day_challenge.domain.user._challenge.exception;

import com.github.thirty_day_challenge.global.exception.ApiExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChallengeExceptions implements ApiExceptionCode {

    INVALID_DATE("CH_001", "날짜 정보가 올바르지 않습니다."),
    ;

    private final String code;
    private final String message;
}
