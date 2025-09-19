package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeDetailResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeListResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "챌린지")
@Auth
@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    @Operation(description = "챌린지 생성")
    public ResponseEntity<ChallengeResponse> createChallenge(
            @CurrentUser User user,
            @RequestBody @Valid CreateChallengeRequest request
    ) {

        return ResponseEntity.ok(challengeService.createChallenge(user, request));
    }

    @GetMapping
    @Operation(description = "참여 중인 챌린지 목록 조회")
    public ResponseEntity<ChallengeListResponse> getAllChallenges(@CurrentUser User user) {

        return ResponseEntity.ok(challengeService.getAllChallenges(user));
    }

    @PostMapping("/{code}")
    @Operation(description = "챌린지 참여")
    public ResponseEntity<Void> participateChallenge(@CurrentUser User user, @PathVariable String code) {

        challengeService.participateChallenge(user, code);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search/{code}")
    @Operation(description = "챌린지 검색")
    public ResponseEntity<ChallengeResponse> searchChallenge(@PathVariable String code) {

        return ResponseEntity.ok(challengeService.searchChallenge(code));

    }

    @GetMapping("/{challenge}")
    @Operation(description = "챌린지 상세 조회")
    public ResponseEntity<ChallengeDetailResponse> getChallengeDetail(
            @CurrentUser User user,
            @Parameter(description = "챌린지 ID", schema = @Schema(type = "string", format = "uuid")) @PathVariable Challenge challenge) {

        return ResponseEntity.ok(challengeService.getChallengeDetail(user, challenge));
    }
}
