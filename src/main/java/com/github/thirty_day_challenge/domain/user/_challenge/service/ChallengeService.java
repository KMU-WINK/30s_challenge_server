package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeListResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final UserChallengeRepository userChallengeRepository;
    private final ChallengeRepository challengeRepository;

    @Transactional
    public CreateChallengeResponse createChallenge(User user, CreateChallengeRequest request) {

        String code = UUID.randomUUID().toString().substring(0, 8);

        Challenge challenge = challengeRepository.save(
                Challenge.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .icon(request.getIcon())
                        .startedAt(request.getStartedAt())
                        .endedAt(request.getEndedAt())
                        .limits(request.getLimits())
                        .code(code)
                        .build()
        );

        userChallengeRepository.save(
                UserChallenge.builder()
                        .user(user)
                        .challenge(challenge)
                        .isOwner(true)
                        .build()
        );

        return CreateChallengeResponse.from(challenge);
    }

    @Transactional(readOnly = true)
    public ChallengeListResponse getAllChallenges(User user) {

        return ChallengeListResponse.from(userChallengeRepository.findByUser(user).stream()
                .map(UserChallenge::getChallenge)
                .toList());
    }
}
