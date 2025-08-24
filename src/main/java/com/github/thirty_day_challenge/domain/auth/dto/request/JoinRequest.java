package com.github.thirty_day_challenge.domain.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "회원가입 요청 DTO")
@AllArgsConstructor(staticName = "of")
public class JoinRequest {

    @Schema(description = "이름")
    @NotBlank
    String name;

    @Schema(description = "이메일")
    @NotBlank
    String email;

    @Schema(description = "아이디")
    @NotBlank
    String nickname;

    @Schema(description = "비밀번호")
    @NotBlank
    String password;
}
