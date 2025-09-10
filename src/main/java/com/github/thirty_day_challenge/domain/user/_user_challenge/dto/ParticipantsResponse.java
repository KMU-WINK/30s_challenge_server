package com.github.thirty_day_challenge.domain.user._user_challenge.dto;

import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ParticipantsResponse {

    UserResponse user;

    boolean isOwner;

    boolean isCompleted;

    int streak;

    public static ParticipantsResponse of(UserChallenge userChallenge, int streak) {
        return ParticipantsResponse.of(
                UserResponse.from(userChallenge.getUser()),
                userChallenge.isOwner(),
                userChallenge.isCompleted(),
                streak
        );
    }
}
