package com.github.thirty_day_challenge.domain.user._challenge.dto.response;

import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "of")
public class SimpleUserResponse {

    UUID id;

    String nickname;

    public static SimpleUserResponse from(User user) {

        return new SimpleUserResponse(
                user.getId(),
                user.getNickname()
        );
    }

}
