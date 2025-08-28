package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "챌린지")
@Auth
@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<CreateChallengeResponse> createChallenge(@RequestBody @Valid CreateChallengeRequest request) {

        return ResponseEntity.ok(challengeService.createChallenge(request));
    }

    @GetMapping
    public List<SimpleChallengeResponse> getAllChallenges(User user) {

        return challengeService.getAllChallenges(user);
    }
}
