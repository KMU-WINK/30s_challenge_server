package com.github.thirty_day_challenge.domain.user._challenge._rank.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge._rank.service.RankService;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._daily_record.dto.DailyRecordResponse;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "랭크")
@Auth
@RestController
@RequiredArgsConstructor
@RequestMapping("/users/challenges")
public class RankController {

    private final RankService rankService;

    @GetMapping("/{challenge}/rank/me")
    @Operation(description = "각 챌린지 내 본인 스트릭 조회")
    public ResponseEntity<DailyRecordResponse> getMyStreak(
            @CurrentUser User user,
            @Parameter(description = "챌린지 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable Challenge challenge
    ) {

        return ResponseEntity.ok(rankService.getMyStreak(user, challenge));
    }

    @GetMapping("/rank/me")
    @Operation(description = "본인의 각 챌린지 스트릭 랭킹 조회")
    public ResponseEntity<List<DailyRecordResponse>> getMyRank(
            @CurrentUser User user
    ) {

        return ResponseEntity.ok(rankService.getMyRank(user));
    }
}
