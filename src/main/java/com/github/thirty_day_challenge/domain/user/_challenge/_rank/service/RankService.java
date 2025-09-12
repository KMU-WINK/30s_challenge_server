package com.github.thirty_day_challenge.domain.user._challenge._rank.service;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.exception.ChallengeExceptions;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.StreakResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {

    private final UserChallengeRepository userChallengeRepository;

    public StreakResponse getMyStreak(User user, Challenge challenge) {

        List<DailyRecord> dailyRecords = userChallengeRepository.findByUserAndChallenge(user, challenge)
                .orElseThrow(ChallengeExceptions.USER_DONT_PARTICIPATE::toException)
                .getDailyRecords()
                .stream()
                .sorted(Comparator.comparing(DailyRecord::getCreatedAt))
                .toList();

        int streak = 0;

        for (DailyRecord dailyRecord : dailyRecords) {

            if (!dailyRecord.isCompleted()) break;

            streak++;
        }

        return StreakResponse.from(challenge, streak);
    }

    public List<StreakResponse> getMyRank(User user) {

        return userChallengeRepository.findByUser(user).stream()
                .map(userChallenge -> getMyStreak(user, userChallenge.getChallenge()))
                .sorted(Comparator.comparingInt(StreakResponse::getStreak).reversed())
                .toList();
    }
}
