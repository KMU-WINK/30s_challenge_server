package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;

    public List<SimpleChallengeResponse> getChallengesByUser(User user) {

        List<Challenge> challenges = challengeRepository.findByUser(user);

        List<SimpleChallengeResponse> challengeResponses = new ArrayList<>();

        for (Challenge challenge : challenges) {
            challengeResponses.add(Challenge.from(challenge));
        }

        return challengeResponses;
    }
}
