package com.github.thirty_day_challenge.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;


@Configuration
public class TimeConfig {

    @Value("${app.time-zone:UTC}")
    private String timeZone;

    @Bean
    public Clock clock() {
        return Clock.system(ZoneId.of(timeZone));
    }
}
