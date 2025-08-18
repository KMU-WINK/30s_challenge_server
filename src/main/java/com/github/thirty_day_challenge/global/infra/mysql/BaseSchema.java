package com.github.thirty_day_challenge.global.infra.mysql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class BaseSchema {

    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "BINARY(16)")
    @NotNull
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    UUID id;

    @Column(nullable = false, updatable = false)
    @NotNull
    @CreatedDate
    LocalDateTime createdAt;

    @Column(nullable = false)
    @NotNull
    @LastModifiedDate
    LocalDateTime updatedAt;
}
