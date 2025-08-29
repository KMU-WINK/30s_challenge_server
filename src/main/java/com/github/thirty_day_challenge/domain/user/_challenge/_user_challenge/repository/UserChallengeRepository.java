package com.github.thirty_day_challenge.domain.user._challenge._user_challenge.repository;

import com.github.thirty_day_challenge.domain.user._challenge._user_challenge.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserChallengeRepository extends JpaRepository<UserChallenge, UUID> {
}
