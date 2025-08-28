package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final UserChallengeRepository userChallengeRepository;

    public List<SimpleChallengeResponse> getAllChallenges(User user) {

        List<Challenge> challenges = userChallengeRepository.findChallengesByUser(user);

        List<SimpleChallengeResponse> responses = new ArrayList<>();

        for (Challenge challenge : challenges) {

            SimpleChallengeResponse dto = SimpleChallengeResponse.from(challenge);
            responses.add(dto); }

        return responses;
    }
}