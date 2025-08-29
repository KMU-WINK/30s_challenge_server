package com.github.thirty_day_challenge.domain.user._challenge.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Schema(description = "챌린지 생성 요청 DTO")
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
