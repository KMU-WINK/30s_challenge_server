package com.github.thirty_day_challenge.domain.user.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    String nickname;

    String password;
}
