package com.github.thirty_day_challenge.domain.auth.repository;

import com.github.thirty_day_challenge.domain.user.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserSessionRepository {

    UUID save(User user);

    Optional<User> findBySessionId(UUID sessionId);

    void delete(UUID sessionId);
}
