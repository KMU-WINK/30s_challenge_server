package com.github.thirty_day_challenge.domain.user._daily_record.entity;

import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class DailyRecord extends BaseSchema {

    @Column(nullable = false)
    private boolean isCompleted = false;

    @Column(nullable = true)
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_challenge_id", nullable = false)
    private UserChallenge userChallenge;
}

