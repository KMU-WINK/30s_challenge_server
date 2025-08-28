package com.github.thirty_day_challenge.domain.user._challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ChallengeCancelResponse {

    private UUID challengeId;
    private String challengeName;
    private boolean owner;
    private String status;
    private List<ParticipantInfo> participants;

    @Data
    @AllArgsConstructor
    public static class ParticipantInfo {
        private UUID userId;
        private String nickname;
        private String status;
    }
}