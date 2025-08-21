package com.github.thirty_day_challenge.domain.auth.util;

import com.github.thirty_day_challenge.domain.auth.repository.UserSessionRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final UserSessionRepository userSessionRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        return request.getCookies() != null &&
                Arrays.stream(request.getCookies())
                        .filter(cookie -> "sessionId".equals(cookie.getName()))
                        .anyMatch(cookie -> userSessionRepository.existsBySessionId(cookie.getValue()));
    }
}
