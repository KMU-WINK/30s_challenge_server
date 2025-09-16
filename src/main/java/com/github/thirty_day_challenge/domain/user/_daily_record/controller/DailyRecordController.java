package com.github.thirty_day_challenge.domain.user._daily_record.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.ListDailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.entity.DailyRecord;
import com.github.thirty_day_challenge.domain.user._daily_record.service.DailyRecordService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "기록")
@Auth
@Validated
@RequestMapping("/users/challenges/{challenge}/records")
@RestController
@RequiredArgsConstructor
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;

    @GetMapping
    @Operation(description = "캘린더 조회")
    public ResponseEntity<ListDailyRecordResponse> getDailyRecords(
            @CurrentUser User user,
            @Parameter(description = "챌린지 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable Challenge challenge,
            @Parameter(description = "연도") @RequestParam(required = false) Integer year,
            @Parameter(description = "월") @RequestParam(required = false) @Min(1) @Max(12) Integer month
    ) {

        return ResponseEntity.ok(dailyRecordService.getDailyRecords(user, challenge, year, month));
    }

    @GetMapping("/{record}")
    @Operation(description = "기록 상세 조회")
    public ResponseEntity<DailyRecordResponse> getDailyRecord(
            @Parameter(description = "챌린지 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable Challenge challenge,
            @Parameter(description = "기록 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable DailyRecord record
    ) {

        return ResponseEntity.ok(dailyRecordService.getDailyRecord(challenge, record));
    }

    @PostMapping("/submit")
    @Operation(description = "기록 생성")
    public ResponseEntity<Void> submitDailyRecord(
            @CurrentUser User user,
            @Parameter(description = "챌린지 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable Challenge challenge,
            @RequestBody @NotBlank String image
    ) {

        dailyRecordService.submitDailyRecord(user, challenge, image);

        return ResponseEntity.ok().build();
    }

}
