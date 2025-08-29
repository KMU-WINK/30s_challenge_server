package com.github.thirty_day_challenge.domain.user._challenge.repository;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {

    boolean existsByCode(String code);
}
