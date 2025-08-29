package com.github.thirty_day_challenge.domain.auth.service;

import com.github.thirty_day_challenge.domain.auth.dto.request.JoinRequest;
import com.github.thirty_day_challenge.domain.auth.dto.request.LoginRequest;
import com.github.thirty_day_challenge.domain.auth.exception.AuthExceptions;
import com.github.thirty_day_challenge.domain.auth.repository.UserSessionRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.domain.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;

    private final PasswordEncoder passwordEncoder;

    public ResponseCookie login(LoginRequest request) {

        User user = userRepository.findByNickname(request.getNickname())
                .orElseThrow(AuthExceptions.AUTHENTICATION_FAILED::toException);

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw AuthExceptions.AUTHENTICATION_FAILED.toException();
        }

        UUID sessionId = userSessionRepository.save(user);

        return ResponseCookie.from("sessionId", sessionId.toString())
                .path("/api")
                .httpOnly(true)
                .build();
    }

    public void join(@Valid JoinRequest request) {

        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .nickname(request.getNickname())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build()
        );
    }
}
