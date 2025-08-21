package com.github.thirty_day_challenge.domain.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "로그인 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class LoginResponse {

    @Schema(description = "세션 ID")
    String sessionId;
}
