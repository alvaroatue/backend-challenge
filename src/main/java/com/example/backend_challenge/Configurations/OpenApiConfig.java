package com.example.backend_challenge.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Backend-Challenge API")
                        .version("1.0")
                        .description("Backend API implemented with Spring Boot RESTful service and documented using springdoc-openapi and Swagger UI"));
    }
}