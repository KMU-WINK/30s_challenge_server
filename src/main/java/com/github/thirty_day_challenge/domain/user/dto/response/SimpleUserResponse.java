package com.github.thirty_day_challenge.domain.user.dto.response;

import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(name = "간단한 유저 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class SimpleUserResponse {

    UUID id;

    String nickname;

    public static SimpleUserResponse from(User user) {

        return SimpleUserResponse.of(
                user.getId(),
                user.getNickname()
        );
    }
}
