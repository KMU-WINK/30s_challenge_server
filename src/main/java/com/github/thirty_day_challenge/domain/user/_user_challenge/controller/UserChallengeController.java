package com.github.thirty_day_challenge.domain.user._user_challenge.controller;

import com.github.thirty_day_challenge.domain.user._user_challenge.service.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserChallengeController {

    private final UserChallengeService userChallengeService;
}
