package com.github.thirty_day_challenge.domain.user._daily_record.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.MyStreakResponse;
import com.github.thirty_day_challenge.domain.user._daily_record.service.RankService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Auth
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/challenges")
public class RankController {

    private final RankService rankService;

    // 챌린지 내 본인 스트릭 조회
    @GetMapping("/{challengeId}/rank/me")
    public ResponseEntity<MyStreakResponse> getMyStreak(@CurrentUser User user, @PathVariable UUID challengeId) {

        return ResponseEntity.ok(rankService.getStreak(user, challengeId));
    }
}
