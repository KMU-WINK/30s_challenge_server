package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;

@Data
@AllArgsConstructor(staticName = "of")
public class SimpleChallengeResponse {

    UUID id;

    String name;

    LocalDate startedAt;

    LocalDate endedAt;

    Challenge.ChallengeStatus status;

    public static SimpleChallengeResponse from(Challenge challenge) {

        return new SimpleChallengeResponse(
                challenge.getId(),
                challenge.getName(),
                challenge.getStartedAt(),
                challenge.getEndedAt(),
                challenge.getStatus()
        );
    }
}
