package com.github.thirty_day_challenge.domain.user._challenge.entity;

import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

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
}
