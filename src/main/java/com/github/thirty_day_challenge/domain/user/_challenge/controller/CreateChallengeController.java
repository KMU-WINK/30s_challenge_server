package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.service.CreateChallengeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenges")
public class CreateChallengeController {

    private final CreateChallengeService createChallengeService;

    @PostMapping
    public ResponseEntity<CreateChallengeResponse> createChallenge(@RequestBody @Valid CreateChallengeRequest request) {
        CreateChallengeResponse response = createChallengeService.create(request);
        return ResponseEntity.ok(response);
    }
}
