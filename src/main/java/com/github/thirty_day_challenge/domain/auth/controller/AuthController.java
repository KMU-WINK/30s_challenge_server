package com.github.thirty_day_challenge.domain.auth.controller;

import com.github.thirty_day_challenge.domain.auth.dto.request.LoginRequest;
import com.github.thirty_day_challenge.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public void login(LoginRequest request) {

        return authService.login(request);
    }
}
