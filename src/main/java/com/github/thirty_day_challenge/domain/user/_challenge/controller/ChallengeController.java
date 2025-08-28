package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
@Tag(name = "챌린지")
public class ChallengeController {

    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<CreateChallengeResponse> createChallenge(@RequestBody @Valid CreateChallengeRequest request) {
        CreateChallengeResponse response = challengeService.create(request);
        return ResponseEntity.ok(response);
    }

}
