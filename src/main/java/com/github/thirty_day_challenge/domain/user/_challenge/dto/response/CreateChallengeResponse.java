package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateChallengeResponse {

    UUID id;
    String name;
    String description;
    String code;
    LocalDate startedAt;
    LocalDate endedAt;
    Integer limit;
    Challenge.ChallengeStatus status;
}
