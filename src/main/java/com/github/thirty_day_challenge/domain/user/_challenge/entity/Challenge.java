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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseSchema {

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
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

    @Column(name = "limit_count")
    @Positive
    private Integer limit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    ChallengeStatus status = ChallengeStatus.ACTIVE;

    public enum ChallengeStatus {
        ACTIVE,
        CANCEL
    }

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    List<UserChallenge> userChallenges = new ArrayList<>();

    @PrePersist
    @PreUpdate
    private void validateDates() {
        if (startedAt != null && endedAt != null && endedAt.isBefore(startedAt)) {
            throw new IllegalStateException("endedAt must be on or after startedAt");
        }
    }

    public void addUserChallenge(UserChallenge uc) {
        this.userChallenges.add(uc);
        uc.setChallenge(this);
    }
    public void removeUserChallenge(UserChallenge uc) {
        this.userChallenges.remove(uc);
        uc.setChallenge(null);
    }
}
