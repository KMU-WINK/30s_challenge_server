package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeListResponse;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.ChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
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
    public ResponseEntity<ChallengeResponse> createChallenge(
            @CurrentUser User user,
            @RequestBody @Valid CreateChallengeRequest request
    ) {

        return ResponseEntity.ok(challengeService.createChallenge(user, request));
    }

    @GetMapping
    public ResponseEntity<ChallengeListResponse> getAllChallenges(@CurrentUser User user) {

        return ResponseEntity.ok(challengeService.getAllChallenges(user));
    }

    @PostMapping("/{code}")
    public ResponseEntity<Void> participateChallenge(@CurrentUser User user, @PathVariable String code) {

        challengeService.participateChallenge(user, code);

        return ResponseEntity.ok().build();
    }
}
