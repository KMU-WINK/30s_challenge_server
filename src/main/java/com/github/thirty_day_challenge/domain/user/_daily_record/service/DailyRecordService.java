package com.github.thirty_day_challenge.domain.user._daily_record.service;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.exception.ChallengeExceptions;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.ListDailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._daily_record.repository.DailyRecordRepository;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

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

    public DailyRecordResponse getDailyRecord(Challenge challenge, DailyRecord dailyRecord) {

        byte[] imageData = dailyRecord.getImageData();
        String base64Image = Base64.getEncoder().encodeToString(imageData);

        return DailyRecordResponse.from(dailyRecord, base64Image);
    }

    public void submitDailyRecord(User user, Challenge challenge, MultipartFile file) {

        UserChallenge userChallenge = userChallengeRepository.findByUserAndChallenge(user, challenge)
                .orElseThrow(ChallengeExceptions.USER_DONT_PARTICIPATE::toException);

        try {
            DailyRecord record = DailyRecord.builder()
                    .imageData(file.getBytes())
                    .imageContentType(file.getContentType())
                    .isCompleted(true)
                    .userChallenge(userChallenge)
                    .build();

            dailyRecordRepository.save(record);
        } catch (IOException e) {
            throw new RuntimeException("이미지 처리 실패", e);
        }
    }
}
