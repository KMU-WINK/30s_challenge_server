package com.github.thirty_day_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ThirtyDayChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThirtyDayChallengeApplication.class, args);
    }

}
