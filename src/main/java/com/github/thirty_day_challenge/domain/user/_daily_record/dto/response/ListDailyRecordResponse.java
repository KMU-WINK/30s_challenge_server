package com.github.thirty_day_challenge.domain.user._daily_record.dto.response;

import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "일일 기록 목록 응답 DTO")
@AllArgsConstructor(staticName = "of")
public class ListDailyRecordResponse {

    List<SimpleDailyRecordResponse> dailyRecords;

    public static ListDailyRecordResponse from(List<DailyRecord> dailyRecords) {

        return ListDailyRecordResponse.of(dailyRecords.stream().map(SimpleDailyRecordResponse::from).toList());
    }
}
