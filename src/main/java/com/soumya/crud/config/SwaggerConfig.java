package com.soumya.crud.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("🎓 Student Management API")
                        .description(
                            "Student's full CRUD System")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Soumya")
                                .email("soumya@gmail.com")));
    }
}