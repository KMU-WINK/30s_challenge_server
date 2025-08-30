package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Schema(description = "챌린지 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class ChallengeResponse {

    UUID id;

    String name;

    String description;

    String code;

    String icon;

    LocalDate startedAt;

    LocalDate endedAt;

    Integer limits;

    public static ChallengeResponse from(Challenge challenge) {

        return ChallengeResponse.of(
                challenge.getId(),
                challenge.getName(),
                challenge.getDescription(),
                challenge.getCode(),
                challenge.getIcon(),
                challenge.getStartedAt(),
                challenge.getEndedAt(),
                challenge.getLimits()
        );
    }
}
