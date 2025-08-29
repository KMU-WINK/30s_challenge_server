package com.github.thirty_day_challenge.domain.user.controller;

import com.github.thirty_day_challenge.domain.auth.annotation.Auth;
import com.github.thirty_day_challenge.domain.user.dto.response.UserResponse;
import com.github.thirty_day_challenge.domain.user.entity.User;
import com.github.thirty_day_challenge.global.util.CurrentUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저")
@Auth
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    @Operation(description = "내 정보 조회")
    public ResponseEntity<UserResponse> getMyInfo(@CurrentUser User user) {

        return ResponseEntity.ok(UserResponse.from(user));
    }
}
