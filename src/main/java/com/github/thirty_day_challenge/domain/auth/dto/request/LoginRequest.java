package com.github.thirty_day_challenge.domain.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class LoginRequest {

    String nickname;

    String password;
}
