package com.github.thirty_day_challenge.domain.user._challenge.repository;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, UUID> {
}
