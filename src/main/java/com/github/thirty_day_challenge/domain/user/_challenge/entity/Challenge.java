package com.github.thirty_day_challenge.domain.user._challenge.entity;

import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Challenge extends BaseSchema {

    String name;

    String description;

    String code;

    LocalDate startedAt;

    LocalDate endedAt;

    Integer limit;

    ChallengeStatus status;

    enum ChallengeStatus {
        ACTIVE,
        CANCEL
    }

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<UserChallenge> userChallenge = List.of();
}
