package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "of")
public class SimpleChallengeResponse {

    UUID id;

    String name;

    String icon;

    LocalDate startedAt;

    LocalDate endedAt;

    public static SimpleChallengeResponse from(Challenge challenge) {

        return new SimpleChallengeResponse(
                challenge.getId(),
                challenge.getName(),
                challenge.getIcon(),
                challenge.getStartedAt(),
                challenge.getEndedAt()
        );
    }
}
