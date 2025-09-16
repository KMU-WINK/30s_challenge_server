package com.github.thirty_day_challenge.domain.user._daily_record.dto.response;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Schema(description = "일일 기록 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class SimpleDailyRecordResponse {

    UUID id;

    LocalDateTime createdAt;

    boolean isCompleted;

    public static SimpleDailyRecordResponse from(DailyRecord record) {

        return SimpleDailyRecordResponse.of(
                record.getId(),
                record.getCreatedAt(),
                record.isCompleted()
        );
    }
}
