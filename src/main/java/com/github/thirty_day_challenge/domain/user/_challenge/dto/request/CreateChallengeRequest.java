package com.github.thirty_day_challenge.domain.user._challenge.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CreateChallengeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private LocalDate startedAt;

    @NotBlank
    private LocalDate endedAt;

    private Integer limit;
}
