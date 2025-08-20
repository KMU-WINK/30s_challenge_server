package com.github.thirty_day_challenge.domain.user._challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
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

    public enum ChallengeStatus {
        ACTIVE, CANCEL
    }

}
