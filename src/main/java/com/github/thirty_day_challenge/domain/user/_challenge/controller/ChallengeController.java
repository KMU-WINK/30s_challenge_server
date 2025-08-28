package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.user._challenge.dto.ChallengeCancelResponse;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
public class ChallengeController {

    private final ChallengeService challengeService;

    @DeleteMapping("/{challengeId}/cancel")
    public ChallengeCancelResponse cancelChallenge(
            @PathVariable UUID challengeId,
            @RequestParam UUID userId
    ) {
        return challengeService.cancelChallenge(challengeId, userId);
    }
}

