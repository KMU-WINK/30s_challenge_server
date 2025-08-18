package com.github.thirty_day_challenge.domain.auth.dto.request;

import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "로그인 요청 DTO")
@AllArgsConstructor(staticName = "of")
public class LoginRequest {

    @Schema(description = "아이디")
    String nickname;

    @Schema(description = "비밀번호")
    String password;

    public static LoginRequest from(User user) {

        return LoginRequest.of(
                user.getNickname(),
                user.getPassword()
        );
    }
}
