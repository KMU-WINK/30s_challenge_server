package com.github.thirty_day_challenge.domain.user._daily_record.dto.response;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "of")
public class DailyRecordResponse {
    UUID id;
    boolean isCompleted;
    String image;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public static DailyRecordResponse from(DailyRecord dailyRecord) {
        return DailyRecordResponse.of(
                dailyRecord.getId(),
                dailyRecord.isCompleted(),
                dailyRecord.getImage(),
                dailyRecord.getCreatedAt(),
                dailyRecord.getUpdatedAt()
        );
    }
}