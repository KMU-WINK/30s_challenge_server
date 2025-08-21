package com.github.thirty_day_challenge.domain._challenge.service;

import com.github.thirty_day_challenge.domain._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain._challenge.repository.ChallengeRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public void cancelChallenge(UUID challengeId) {

        Challenge challenge = challengeRepository.findById(challengeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 챌린지를 찾을 수 없습니다."));

        challenge.cancel();

        challengeRepository.save(challenge);
    }
}
