package com.github.thirty_day_challenge.domain.user._daily_record.repository;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DailyRecordRepository extends JpaRepository<DailyRecord, UUID> {
    List<DailyRecord> findByUserChallenge(UserChallenge userChallenge);
}
