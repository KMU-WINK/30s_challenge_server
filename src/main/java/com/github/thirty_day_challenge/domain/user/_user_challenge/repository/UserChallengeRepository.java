package com.github.thirty_day_challenge.domain.user._user_challenge.repository;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, UUID> {

    @EntityGraph(attributePaths = "challenge")
    List<UserChallenge> findByUser(User user);

    @EntityGraph(attributePaths = {"name", "challenge"})
    Optional<UserChallenge> findByUserAndChallenge(User user, Challenge challenge);
}
