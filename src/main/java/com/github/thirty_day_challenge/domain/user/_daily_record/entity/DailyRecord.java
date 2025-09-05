package com.github.thirty_day_challenge.domain.user._daily_record.entity;

import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import com.github.thirty_day_challenge.domain.user._user_challenge.entity.UserChallenge;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DailyRecord extends BaseSchema {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_challenge_id", nullable = false)
    private UserChallenge userChallenge;

    @Column(nullable = false)
    private boolean isCompleted = false;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(nullable = true, length = 2048)
    private String image;

}