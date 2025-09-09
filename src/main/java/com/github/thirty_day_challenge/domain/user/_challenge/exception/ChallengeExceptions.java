package com.github.thirty_day_challenge.domain.user._challenge.exception;

import com.github.thirty_day_challenge.global.exception.ApiExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ChallengeExceptions implements ApiExceptionCode {

    INVALID_DATE("CH_001", "날짜 정보가 올바르지 않습니다."),
    NOT_FOUND("CH_002", "챌린지를 찾을 수 없습니다."),
    USER_DONT_PARTICIPATE("CH_003", "유저가 챌린지에 참여하고 있지 않습니다."),
    LIMITS_REACHED("CH_004", "챌린지 참여 제한 인원수가 이미 채워졌습니다.")
    ;

    private final String code;
    private final String message;
}
