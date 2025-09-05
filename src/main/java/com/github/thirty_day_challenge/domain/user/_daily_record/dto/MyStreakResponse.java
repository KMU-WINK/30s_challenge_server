package com.github.thirty_day_challenge.domain.user._daily_record.dto;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyStreakResponse {

    private SimpleChallengeResponse challenge;
    private Integer streak;
}
