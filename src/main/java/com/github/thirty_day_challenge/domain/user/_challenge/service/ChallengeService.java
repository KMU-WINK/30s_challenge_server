package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeDetailResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeListResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.exception.ChallengeExceptions;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final UserChallengeRepository userChallengeRepository;
    private final ChallengeRepository challengeRepository;

    @Transactional
    public ChallengeResponse createChallenge(User user, CreateChallengeRequest request) {

        if (request.getEndedAt().isBefore(request.getStartedAt())) {

            throw ChallengeExceptions.INVALID_DATE.toException();
        }

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

        return ChallengeResponse.from(challenge);
    }

    @Transactional(readOnly = true)
    public ChallengeListResponse getAllChallenges(User user) {

        return ChallengeListResponse.from(userChallengeRepository.findByUser(user).stream()
                .map(UserChallenge::getChallenge)
                .toList());
    }

    @Transactional
    public void participateChallenge(User user, String code) {

        Challenge challenge = challengeRepository.findByCode(code)
                .orElseThrow(ChallengeExceptions.NOT_FOUND::toException);

        Integer joined = userChallengeRepository.countByChallengeId(challenge.getId());
        Integer limits = challenge.getLimits();

        if (limits != null && joined >= limits) {
            throw ChallengeExceptions.LIMITS_REACHED.toException();
        }

        if (userChallengeRepository.existsByUserAndChallenge(user, challenge)) {
            throw ChallengeExceptions.ALREADY_PARTICIPATED.toException();
        }

        UserChallenge userChallenge = UserChallenge.builder()
                .user(user)
                .challenge(challenge)
                .isOwner(false)
                .build();

        userChallengeRepository.save(userChallenge);
    }

    @Transactional(readOnly = true)
    public ChallengeResponse searchChallenge(String code) {

        return ChallengeResponse.from(challengeRepository.findByCode(code)
                .orElseThrow(ChallengeExceptions.NOT_FOUND::toException));
    }

    @Transactional(readOnly = true)
    public ChallengeDetailResponse getChallengeDetail(User user, Challenge challenge) {

        List<User> users = userChallengeRepository.findByChallenge(challenge).stream()
                .map(UserChallenge::getUser)
                .toList();

        if (users.stream().noneMatch(u -> u.equals(user))) {

            throw ChallengeExceptions.USER_DONT_PARTICIPATE.toException();
        }

        return ChallengeDetailResponse.from(challenge, users);
    }
}
