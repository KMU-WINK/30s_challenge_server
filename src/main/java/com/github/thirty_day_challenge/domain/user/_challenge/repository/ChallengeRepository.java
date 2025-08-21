package com.github.thirty_day_challenge.domain.user._challenge.repository;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ChallengeRepository extends CrudRepository<Challenge, UUID> {
}
