package com.github.thirty_day_challenge.domain.auth.dto.request;

import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "회원가입 요청 DTO")
@AllArgsConstructor(staticName = "of")
public class JoinRequest {

    @Schema(description = "이름")
    String name;

    @Schema(description = "이메일")
    String email;

    @Schema(description = "아이디")
    String nickname;

    @Schema(description = "비밀번호")
    String password;

    public static JoinRequest from(User user) {

        return JoinRequest.of(
                user.getName(),
                user.getEmail(),
                user.getNickname(),
                user.getPassword()
        );
    }
}
