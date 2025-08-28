package com.github.thirty_day_challenge.domain.user._challenge.controller;

import com.github.thirty_day_challenge.domain.user._challenge.dto.response.SimpleChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.service.ChallengeService;
import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/challenges")
@RequiredArgsConstructor
@Tag(name = "챌린지")
public class ChallengeController {

    private final ChallengeService challengeService;

    @GetMapping
    public List<SimpleChallengeResponse> getAllChallenges(User user) {

        return challengeService.getAllChallenges(user);
    }
}