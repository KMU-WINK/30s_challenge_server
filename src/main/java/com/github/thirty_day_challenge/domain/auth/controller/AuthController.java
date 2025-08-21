package com.github.thirty_day_challenge.domain.auth.controller;

import com.github.thirty_day_challenge.domain.auth.dto.request.JoinRequest;
import com.github.thirty_day_challenge.domain.auth.dto.request.LoginRequest;
import com.github.thirty_day_challenge.domain.auth.dto.response.LoginResponse;
import com.github.thirty_day_challenge.domain.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/join")
    @Operation(description = "회원가입")
    public ResponseEntity<Void> join(@RequestBody @Valid JoinRequest request) {

        authService.join(request);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    @Operation(description = "로그인")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {

        ResponseCookie cookie = ResponseCookie
                .from("sessionId", authService.login(request).toString())
                .path("/api")
                .build();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(null);
    }
}
