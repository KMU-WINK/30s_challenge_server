package com.github.thirty_day_challenge.domain.user.entity;

import com.github.thirty_day_challenge.global.infra.mysql.BaseSchema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseSchema {

    @Column(nullable = false, unique = true)
    @NotBlank
    String name;

    @Column(nullable = false, unique = true)
    @NotBlank
    String email;

    @Column(nullable = false, unique = true)
    @NotBlank
    String nickname;

    @Column(nullable = false)
    @NotBlank
    String password;
}
