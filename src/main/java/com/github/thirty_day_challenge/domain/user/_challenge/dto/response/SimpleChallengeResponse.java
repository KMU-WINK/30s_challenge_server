package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class SimpleChallengeResponse {

    UUID id;

    String name;

    LocalDate startedAt;

    LocalDate endedAt;

    Challenge.ChallengeStatus status;

}
