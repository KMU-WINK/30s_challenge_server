package com.github.thirty_day_challenge.domain.user._daily_record.service;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.exception.ChallengeExceptions;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.ListDailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.repository.DailyRecordRepository;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyRecordService {

    private final UserChallengeRepository userChallengeRepository;
    private final DailyRecordRepository dailyRecordRepository;

    public ListDailyRecordResponse getDailyRecords(User user, Challenge challenge, Integer year, Integer month) {

        UserChallenge userChallenge = userChallengeRepository.findByUserAndChallenge(user, challenge)
                .orElseThrow(ChallengeExceptions.USER_DONT_PARTICIPATE::toException);

        return ListDailyRecordResponse.from(dailyRecordRepository.findByUserChallengeAndYearAndMonth(userChallenge, year, month));
    }
}
