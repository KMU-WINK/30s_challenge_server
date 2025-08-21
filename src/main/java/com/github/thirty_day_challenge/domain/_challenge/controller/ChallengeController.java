package com.github.thirty_day_challenge.domain._challenge.controller;

import com.github.thirty_day_challenge.domain._challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @DeleteMapping("/{challengeId}/cancel")
    public ResponseEntity<Void> cancelChallenge(@PathVariable UUID challengeId) {
        challengeService.cancelChallenge(challengeId);
        return ResponseEntity.noContent().build();
    }
}
