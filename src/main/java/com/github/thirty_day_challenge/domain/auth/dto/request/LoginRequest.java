package com.github.thirty_day_challenge.domain.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "로그인 요청 DTO")
@AllArgsConstructor(staticName = "of")
public class LoginRequest {

    @Schema(description = "아이디")
    @NotBlank
    String nickname;

    @Schema(description = "비밀번호")
    @NotBlank
    String password;
}
