package com.github.thirty_day_challenge.domain.auth.repository;

import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Repository
@RequiredArgsConstructor
public class UserSessionRepositoryImpl implements UserSessionRepository {

    private final UserRepository userRepository;

    private final HashMap<UUID, Supplier<User>> userSessions = new HashMap<>();

    public UUID save(User user) {

        UUID sessionId = UUID.randomUUID();

        userSessions.put(sessionId, () -> userRepository.findById(user.getId()).orElseThrow());

        return sessionId;
    }

    public Optional<User> findBySessionId(UUID sessionId) {

        return Optional.ofNullable(userSessions.get(sessionId)).map(Supplier::get);
    }

    public void delete(UUID sessionId) {

        userSessions.remove(sessionId);
    }
}
