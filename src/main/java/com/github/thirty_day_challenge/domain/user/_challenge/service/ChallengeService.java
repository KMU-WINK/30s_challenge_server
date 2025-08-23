package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
}
