package com.github.thirty_day_challenge.domain.user._user_challenge.dto;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "참여자 순위 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class UserChallengeRankResponse {

    private SimpleChallengeResponse challenge;

    private List<ParticipantsResponse> participants;

    public static UserChallengeRankResponse from(Challenge challenge, List<ParticipantsResponse> participants) {

        return UserChallengeRankResponse.of(
                SimpleChallengeResponse.from(challenge),
                participants
        );
    }
}
