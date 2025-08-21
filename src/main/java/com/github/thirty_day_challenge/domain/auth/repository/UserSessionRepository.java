package com.github.thirty_day_challenge.domain.auth.repository;

import com.github.thirty_day_challenge.domain.user.entity.User;

import java.util.Optional;

public interface UserSessionRepository {

    String save(User user);

    Optional<User> findBySessionId(String sessionId);

    boolean existsBySessionId(String sessionId);

    void delete(String sessionId);
}
