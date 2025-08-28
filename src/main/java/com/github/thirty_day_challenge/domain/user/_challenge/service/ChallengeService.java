package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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
                        .limits(request.getLimits())
                        .code(code)
                        .build()
        );

        return CreateChallengeResponse.from(challenge);
    }

    public List<SimpleChallengeResponse> getAllChallenges(User user) {

        List<Challenge> challenges = userChallengeRepository.findChallengesByUser(user);

        List<SimpleChallengeResponse> responses = new ArrayList<>();

        for (Challenge challenge : challenges) {

            SimpleChallengeResponse dto = SimpleChallengeResponse.from(challenge);
            responses.add(dto); }

        return responses;
    }
}
