package com.github.thirty_day_challenge.domain.user._user_challenge.service;

import com.github.thirty_day_challenge.domain.user._user_challenge.repository.UserChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChallengeService {

    private final UserChallengeRepository userChallengeRepository;
}