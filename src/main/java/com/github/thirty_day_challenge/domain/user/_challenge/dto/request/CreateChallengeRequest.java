package com.github.thirty_day_challenge.domain.user._challenge.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateChallengeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @FutureOrPresent
    private LocalDate startedAt;

    @NotNull
    @FutureOrPresent
    private LocalDate endedAt;

    @NotNull
    @Positive
    private Integer limit;
}
