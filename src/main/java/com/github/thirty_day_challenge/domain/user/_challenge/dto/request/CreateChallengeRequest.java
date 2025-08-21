package com.github.thirty_day_challenge.domain.user._challenge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateChallengeRequest {

    private String name;
    private String description;
    private LocalDate startedAt;
    private LocalDate endedAt;
    private Integer limit;
}