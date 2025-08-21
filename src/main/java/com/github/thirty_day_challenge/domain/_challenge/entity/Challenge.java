package com.github.thirty_day_challenge.domain._challenge.entity;

import com.github.thirty_day_challenge.domain._challenge.dto.response.SimpleChallengeResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Challenge {

    @Id
    private UUID id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String name;

    private String description;

    private String code;

    private LocalDate startedAt;

    private LocalDate endedAt;

    private Integer limit;

    private ChallengeStatus status;

    public void cancel() {
        this.status = ChallengeStatus.CANCEL;
    }

    public enum ChallengeStatus {
        ACTIVE,
        COMPLETED,
        CANCEL
    }

    public static SimpleChallengeResponse from(Challenge challenge) {
        return SimpleChallengeResponse.builder()
                .id(challenge.getId())
                .name(challenge.getName())
                .startedAt(challenge.getStartedAt())
                .endedAt(challenge.getEndedAt())
                .status(challenge.getStatus())
                .build();
    }
}
