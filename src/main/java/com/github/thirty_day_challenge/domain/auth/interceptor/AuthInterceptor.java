package com.github.thirty_day_challenge.domain.auth.interceptor;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.auth.exception.AuthExceptions;
import com.github.thirty_day_challenge.domain.auth.repository.UserSessionRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final UserSessionRepository userSessionRepository;

    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler) {

        if (handler instanceof HandlerMethod handlerMethod
                && (handlerMethod.hasMethodAnnotation(Auth.class)
                || handlerMethod.getBeanType().isAnnotationPresent(Auth.class))) {

            Optional.ofNullable(request.getCookies())
                    .map(cookies -> Arrays.stream(cookies)
                            .filter(cookie -> "sessionId".equals(cookie.getName()))
                            .map(Cookie::getValue)
                            .map(UUID::fromString)
                            .map(userSessionRepository::findBySessionId)
                            .findFirst()
                            .orElseThrow(AuthExceptions.AUTHENTICATION_FAILED::toException))
                    .orElseThrow(AuthExceptions.AUTHENTICATION_FAILED::toException);
        }

        return true;
    }
}
