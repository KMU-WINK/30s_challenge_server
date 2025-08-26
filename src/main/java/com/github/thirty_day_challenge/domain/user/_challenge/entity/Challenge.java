package com.github.thirty_day_challenge.domain.user._challenge.entity;

import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseSchema {

    @Column(nullable = false)
    String name;

    String description;

    @Column(nullable = false, unique = true)
    String code;

    LocalDate startedAt;

    LocalDate endedAt;

    @Column(name = "limit_count")
    Integer limit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    ChallengeStatus status = ChallengeStatus.ACTIVE;

    public enum ChallengeStatus {
        ACTIVE,
        CANCEL
    }

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<UserChallenge> userChallenge = new ArrayList<>();
}
