package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    @Transactional
    public CreateChallengeResponse createChallenge(CreateChallengeRequest request) {

        String code = UUID.randomUUID().toString().substring(0, 8);

        Challenge challenge = challengeRepository.save(
                Challenge.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .startedAt(request.getStartedAt())
                        .endedAt(request.getEndedAt())
                        .limit(request.getLimit())
                        .code(code)
                        .build()
        );

        return CreateChallengeResponse.from(challenge);
    }
}
