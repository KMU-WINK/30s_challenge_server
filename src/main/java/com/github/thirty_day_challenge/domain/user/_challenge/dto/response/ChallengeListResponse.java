package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class ChallengeListResponse {

    List<SimpleChallengeResponse> challenges;

    public static ChallengeListResponse from(List<Challenge> challenges) {

        return ChallengeListResponse.of(challenges.stream().map(SimpleChallengeResponse::from).toList());
    }
}
