package com.github.thirty_day_challenge.domain.user._user_challenge.dto;

import com.github.thirty_day_challenge.domain.user.dto.response.SimpleUserResponse;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class ParticipantsResponse {

    SimpleUserResponse user;

    int streak;

    public static ParticipantsResponse from(User user, int streak) {

        return ParticipantsResponse.of(
                SimpleUserResponse.from(user),
                streak
        );
    }
}
