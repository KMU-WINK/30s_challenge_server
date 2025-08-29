package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Schema(description = "챌린지 생성 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class CreateChallengeResponse {

    UUID id;

    String name;

    String description;

    String code;

    LocalDate startedAt;

    LocalDate endedAt;

    Integer limit;

    Challenge.ChallengeStatus status;

    public static CreateChallengeResponse from(Challenge challenge) {

        return CreateChallengeResponse.of(
                challenge.getId(),
                challenge.getName(),
                challenge.getDescription(),
                challenge.getCode(),
                challenge.getStartedAt(),
                challenge.getEndedAt(),
                challenge.getLimit(),
                challenge.getStatus()
        );
    }
}
