package com.github.thirty_day_challenge.domain.auth.service;

import com.github.thirty_day_challenge.domain.auth.dto.request.JoinRequest;
import com.github.thirty_day_challenge.domain.auth.dto.request.LoginRequest;
import com.github.thirty_day_challenge.domain.auth.dto.response.LoginResponse;
import com.github.thirty_day_challenge.domain.auth.exception.AuthExceptions;
import com.github.thirty_day_challenge.domain.auth.repository.UserSessionRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.domain.user.exception.UserExceptions;
import com.github.thirty_day_challenge.domain.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByNickname(request.getNickname())
                .orElseThrow(UserExceptions.NOT_FOUND::toException);

        // TODO: 비밀번호 해싱하기
        if (!user.getPassword().equals(request.getPassword())) {

            throw AuthExceptions.NOT_EQUAL_PASSWORD.toException();
        }

        return LoginResponse.of(userSessionRepository.save(user));
    }

    public void join(@Valid JoinRequest request) {

        userRepository.save(
                User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .nickname(request.getNickname())
                        .password(request.getPassword())
                        .build()
        );
    }
}
