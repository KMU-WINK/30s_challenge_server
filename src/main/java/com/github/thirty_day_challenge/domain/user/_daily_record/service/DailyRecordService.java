package com.github.thirty_day_challenge.domain.user._daily_record.service;

import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.repository.DailyRecordRepository;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyRecordService {

    private final DailyRecordRepository dailyRecordRepository;

    public List<DailyRecordResponse> getDailyRecords(
            UserChallenge userChallenge,
            Integer year,
            Integer month
    ) {

        if (year != null && month != null) {
            LocalDate startDate = LocalDate.of(year, month, 1);
            LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

            return dailyRecordRepository.findByUserChallengeAndRecordDateBetweenOrderByRecordDateAsc(
                    userChallenge, startDate, endDate
            )
                    .stream()
                    .map(DailyRecordResponse::from)
                    .collect(Collectors.toList());
        }


        return dailyRecordRepository
                .findByUserChallengeOrderByRecordDateAsc(userChallenge)
                .stream()
                .map(DailyRecordResponse::from)
                .collect(Collectors.toList());
    }
}