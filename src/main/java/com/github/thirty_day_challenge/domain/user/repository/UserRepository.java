package com.github.thirty_day_challenge.domain.user.repository;

import com.github.thirty_day_challenge.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByNickname(String nickname);
}
