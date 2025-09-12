package com.github.thirty_day_challenge.domain.user._daily_record.dto;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Schema(description = "기록 상세 조회 DTO")
@AllArgsConstructor(staticName = "of")
public class DailyRecordResponse {

    UUID id;

    LocalDateTime createdAt;

    boolean isCompleted;

    String image;

    public static DailyRecordResponse from(DailyRecord record) {

        return DailyRecordResponse.of(
                record.getId(),
                record.getCreatedAt(),
                record.isCompleted(),
                record.getImage()
        );
    }
}
