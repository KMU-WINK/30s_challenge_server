package com.github.thirty_day_challenge.domain.user._challenge.service;

import com.github.thirty_day_challenge.domain.user._challenge.dto.request.CreateChallengeRequest;
import com.github.thirty_day_challenge.domain.user._challenge.dto.response.CreateChallengeResponse;
import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user._challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateChallengeService {

    private final ChallengeRepository createChallengeRepository;

    public CreateChallengeResponse create(CreateChallengeRequest request) {

        // challenge 생성
        Challenge challenge = new Challenge();
        challenge.setName(request.getName());
        challenge.setDescription(request.getDescription());
        challenge.setStartedAt(request.getStartedAt());
        challenge.setEndedAt(request.getEndedAt());
        challenge.setLimit(request.getLimit());
        challenge.setCode(UUID.randomUUID().toString().substring(0, 8));

        // challenge 저장
        Challenge saved = createChallengeRepository.save(challenge);

        return new CreateChallengeResponse(
                saved.getId(),
                saved.getName(),
                saved.getDescription(),
                saved.getCode(),
                saved.getStartedAt(),
                saved.getEndedAt(),
                saved.getLimit(),
                saved.getStatus()
        );
    }
}
