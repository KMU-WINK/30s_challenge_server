package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user.dto.response.SimpleUserResponse;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
public class ChallengeDetailResponse {

    ChallengeResponse challenge;

    List<SimpleUserResponse> participants;

    public static ChallengeDetailResponse from(Challenge challenge, List<User> participants) {

        return ChallengeDetailResponse.of(
                ChallengeResponse.from(challenge),
                participants.stream().map(SimpleUserResponse::from).toList()
        );
    }
}
