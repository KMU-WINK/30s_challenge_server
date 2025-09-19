package com.github.thirty_day_challenge.domain.user._daily_record.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user.dto.response.SimpleUserResponse;
import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "스트릭 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class StreakResponse {

    private SimpleUserResponse user;

    private SimpleChallengeResponse challenge;

    private Integer streak;

    public static StreakResponse from(User user, Challenge challenge, Integer streak) {

        return StreakResponse.of(
                SimpleUserResponse.from(user),
                SimpleChallengeResponse.from(challenge),
                streak
        );
    }
}
