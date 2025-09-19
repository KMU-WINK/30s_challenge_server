package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Schema(name = "간단한 챌린지 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class SimpleChallengeResponse {

    UUID id;

    String name;

    String icon;

    LocalDate startedAt;

    LocalDate endedAt;

    public static SimpleChallengeResponse from(Challenge challenge) {

        return SimpleChallengeResponse.of(
                challenge.getId(),
                challenge.getName(),
                challenge.getIcon(),
                challenge.getStartedAt(),
                challenge.getEndedAt()
        );
    }
}
