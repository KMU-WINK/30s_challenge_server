package com.github.thirty_day_challenge.domain.user._user_challenge.entity;

import com.github.thirty_day_challenge.domain.user._challenge.entity.Challenge;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.*;
import lombok.*;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "challenge_id"}))
@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserChallenge extends BaseSchema {

    @Column(nullable = false)
    boolean isOwner = false;

    @Column(nullable = false)
    boolean hasBadge;

    @Column(nullable = false)
    @Builder.Default
    @Enumerated(EnumType.STRING)
    ParticipantStatus status = ParticipantStatus.WAITING;

    public enum ParticipantStatus {
        WAITING,
        ACCEPT,
        REJECT
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "challenge_id", nullable = false)
    Challenge challenge;
}
