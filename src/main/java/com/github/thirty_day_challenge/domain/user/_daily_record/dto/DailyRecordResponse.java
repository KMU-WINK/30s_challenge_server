package com.github.thirty_day_challenge.domain.user._daily_record.dto;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "일일 기록 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class DailyRecordResponse {

    private SimpleChallengeResponse challenge;

    private Integer streak;

    public static DailyRecordResponse from(Challenge challenge, Integer streak) {

        return DailyRecordResponse.of(
                SimpleChallengeResponse.from(challenge),
                streak
        );
    }
}
