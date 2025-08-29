package com.github.thirty_day_challenge.domain.user.dto.response;

import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@Schema(description = "유저 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class UserResponse {

    UUID id;

    String name;

    String email;

    String nickname;

    public static UserResponse from(User user) {

        return UserResponse.of(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getNickname()
        );
    }
}
