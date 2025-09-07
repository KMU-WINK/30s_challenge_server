package com.github.thirty_day_challenge.domain.user._daily_record.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.response.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.service.DailyRecordService;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Tag(name = "챌린지 기록")
@Auth
@RestController
@RequestMapping("/users/challenges/{challengeId}/records")
@RequiredArgsConstructor
public class DailyRecordController {

    private final DailyRecordService dailyRecordService;
    private final UserChallengeRepository userChallengeRepository;

    @GetMapping
    public ResponseEntity<List<DailyRecordResponse>> getDailyRecords(
            @CurrentUser User user,
            @PathVariable UUID challengeId,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer month
    ) {
        UserChallenge userChallenge = userChallengeRepository
                .findByUserIdAndChallengeId(user.getId(), challengeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.FORBIDDEN, ("해당 챌린지에 참여하고 있지 않습니다."))
                );

        return ResponseEntity.ok(dailyRecordService.getDailyRecords(userChallenge, year, month));
    }
}