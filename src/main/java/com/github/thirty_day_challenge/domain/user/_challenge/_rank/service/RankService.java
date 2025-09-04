package com.github.thirty_day_challenge.domain.user._challenge._rank.service;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._daily_record.repository.DailyRecordRepository;
import com.github.thirty_day_challenge.domain.user._challenge._rank.dto.MyStreakResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RankService {

    private final UserChallengeRepository userChallengeRepository;
    private final DailyRecordRepository dailyRecordRepository;

    public MyStreakResponse getStreak(@CurrentUser User user, UUID challengeId) {

        UserChallenge userChallenge = userChallengeRepository
                .findByUserAndChallengeId(user, challengeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "UserChallenge not found"));

        List<DailyRecord> records = dailyRecordRepository
                .findAllByUserChallengeOrderByCreatedAtAsc(userChallenge);

        Set<LocalDate> completedDays = records.stream()
                .filter(DailyRecord::isCompleted)
                .map(r -> r.getCreatedAt().toLocalDate())
                .collect(Collectors.toSet());

        int streak = 0;
        LocalDate today = LocalDate.now();

        LocalDate day = completedDays.contains(today) ? today : today.minusDays(1);

        while (completedDays.contains(day)) {
            streak++;
            day = day.minusDays(1);
        }

        return new MyStreakResponse(
                SimpleChallengeResponse.from(userChallenge.getChallenge()),
                streak
            );
    }
}
