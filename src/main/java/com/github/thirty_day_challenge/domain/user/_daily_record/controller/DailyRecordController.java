package com.github.thirty_day_challenge.domain.user._daily_record.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.service.DailyRecordService;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Tag(name = "챌린지 기록")
@Auth
@RestController
@RequestMapping("/users/challenges/{challengeId}/records")
@RequiredArgsConstructor
@Validated
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;
    private final UserChallengeRepository userChallengeRepository;

    @GetMapping
    public ResponseEntity<List<DailyRecordResponse>> getDailyRecords(
            @CurrentUser User user,
            @PathVariable UUID challengeId,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) @Min(1) @Max(12) Integer month
    ) {
        if ((year == null) != (month == null)) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "year와 month는 함께 제공해야 합니다.");
        }
        UserChallenge userChallenge = userChallengeRepository
                .findByUserIdAndChallengeId(user.getId(), challengeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.FORBIDDEN, ("해당 챌린지에 참여하고 있지 않습니다."))
                );

        return ResponseEntity.ok(dailyRecordService.getDailyRecords(userChallenge, year, month));
    }
}