package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    String code = generateUniqueCode();

    @org.springframework.transaction.annotation.Transactional
    public CreateChallengeResponse create(CreateChallengeRequest request) {

        if (request.getStartedAt() != null && request.getEndedAt() != null
                && request.getEndedAt().isBefore(request.getStartedAt())) {
            throw new IllegalArgumentException("endedAt must be on/after startedAt");
        }
        if (request.getLimit() != null && request.getLimit() <= 0) {
            throw new IllegalArgumentException("limit must be positive");
        }

        Challenge challenge = Challenge.builder()
                .name(request.getName())
                .description(request.getDescription())
                .startedAt(request.getStartedAt())
                .endedAt(request.getEndedAt())
                .limit(request.getLimit())
                .code(code)
                .build();

        Challenge savedChallenge = challengeRepository.save(challenge);

        return new CreateChallengeResponse(
                savedChallenge.getId(),
                savedChallenge.getName(),
                savedChallenge.getDescription(),
                savedChallenge.getCode(),
                savedChallenge.getStartedAt(),
                savedChallenge.getEndedAt(),
                savedChallenge.getLimit(),
                savedChallenge.getStatus()
        );
    }

    private String generateUniqueCode() {

        String code;

        do {
            code = UUID.randomUUID().toString().substring(0, 8);
        } while (challengeRepository.existsByCode(code));
        return code;
    }
}
