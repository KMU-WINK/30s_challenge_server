package com.github.thirty_day_challenge.domain.auth.service;

import com.github.thirty_day_challenge.domain.auth.dto.request.LoginRequest;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void login(LoginRequest request) {

        User user = userRepository.findByNickname(request.getNickname());

        if (user.getPassword().equals(request.getPassword())) {
            // 로그인 성공
        } else {
            // 로그인 실패
        }
    }
}
