package com.github.thirty_day_challenge.global.config;

import com.github.thirty_day_challenge.domain.user.entity.User;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.annotation.PostConstruct;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @PostConstruct
    public void init() {

        SpringDocUtils.getConfig().addRequestWrapperToIgnore(User.class);
    }

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
