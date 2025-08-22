package com.github.thirty_day_challenge.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("cookie",
                                new SecurityScheme()
                                        .in(SecurityScheme.In.COOKIE)
                                        .type(SecurityScheme.Type.APIKEY)
                                        .name("sessionId")));
    }
}
