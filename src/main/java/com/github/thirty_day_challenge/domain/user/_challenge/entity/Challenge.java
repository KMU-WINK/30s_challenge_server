package com.github.thirty_day_challenge.domain.user._challenge.entity;

import com.github.thirty_day_challenge.domain.user._challenge.ChallengeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Challenge {

    @Id
    @Column(nullable = false, unique = true)
    UUID id;

    @Column(nullable = false)
    LocalDateTime createdAt;

    @Column(nullable = false)
    LocalDateTime updatedAt;

    @Column(nullable = false)
    @NotBlank
    String name;

    @Column(nullable = false)
    @NotBlank
    String description;

    @Column(nullable = false)
    @NotBlank
    String code;

    @Column(nullable = false)
    LocalDate startedAt;

    @Column(nullable = false)
    LocalDate endedAt;

    Integer limit;

    @Column(nullable = false)
    ChallengeStatus status;
}
