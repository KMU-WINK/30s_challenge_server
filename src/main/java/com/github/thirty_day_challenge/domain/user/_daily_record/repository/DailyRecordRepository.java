package com.github.thirty_day_challenge.domain.user._daily_record.repository;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, UUID> {

    @Query("SELECT dr FROM DailyRecord dr WHERE dr.userChallenge = :userChallenge AND YEAR(dr.createdAt) = :year AND MONTH(dr.createdAt) = :month")
    List<DailyRecord> findByUserChallengeAndYearAndMonth(UserChallenge userChallenge, Integer year, Integer month);
}
