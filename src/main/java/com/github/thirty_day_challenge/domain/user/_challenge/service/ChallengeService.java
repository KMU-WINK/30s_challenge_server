package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.ChallengeCancelResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
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
    private final UserChallengeRepository userChallengeRepository;

    @Transactional
    public ChallengeCancelResponse cancelChallenge(UUID challengeId, UUID userId) {
        UserChallenge userChallenge = userChallengeRepository
                .findByChallengeIdAndUserId(challengeId, userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 챌린지에 참여하지 않은 사용자입니다."));

        Challenge challenge = userChallenge.getChallenge();
        boolean isOwner = userChallenge.isOwner();

        List<ChallengeCancelResponse.ParticipantInfo> participants = new ArrayList<>();

        if (isOwner) {
            challenge.setStatus(Challenge.ChallengeStatus.CANCEL);

            List<UserChallenge> allParticipants = userChallengeRepository.findAllByChallengeId(challengeId);
            for (UserChallenge participant : allParticipants) {
                participant.setStatus(UserChallenge.ParticipantStatus.REJECT);
                participants.add(new ChallengeCancelResponse.ParticipantInfo(
                        participant.getUser().getId(),
                        participant.getUser().getNickname(),
                        participant.getStatus().name()
                ));
            }
        } else {
            userChallenge.setStatus(UserChallenge.ParticipantStatus.REJECT);

            participants.add(new ChallengeCancelResponse.ParticipantInfo(
                    userChallenge.getUser().getId(),
                    userChallenge.getUser().getNickname(),
                    userChallenge.getStatus().name()
            ));
        }

        return new ChallengeCancelResponse(
                challenge.getId(),
                challenge.getName(),
                isOwner,
                challenge.getStatus().name(),
                participants
        );
    }
}
