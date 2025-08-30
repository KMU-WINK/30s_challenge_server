package com.github.thirty_day_challenge.domain.user._challenge.entity;

import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseSchema {

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column
    private String description;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String code;

    @Column(nullable = false)
    @NotNull
    private LocalDate startedAt;

    @Column(nullable = false)
    @NotNull
    private LocalDate endedAt;

    @Positive
    private Integer limits;

    @Column(nullable = false)
    @Builder.Default
    @Enumerated(EnumType.STRING)
    ChallengeStatus status = ChallengeStatus.ACTIVE;

    public enum ChallengeStatus {
        ACTIVE,
        CANCEL
    }

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    List<UserChallenge> userChallenges = new ArrayList<>();
}
