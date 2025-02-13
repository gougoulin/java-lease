package com.github.gougoulin.lease.web.admin.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Lease Admin APIs").version("1.0").description("Lease Admin API"));
    }

    // API group for health check and others
    @Bean
    public GroupedOpenApi healthAPI() {
        return GroupedOpenApi.builder().group("Health Check").pathsToMatch("/healthcheck").build();
    }

    // Include API docs for system related endpoints
    @Bean
    public GroupedOpenApi systemInfoAPI() {
        return GroupedOpenApi.builder().group("System Info").pathsToMatch("/admin/system/**").build();
    }

    // Include API docs for authentication related endpoints
    // Such as user login, logout, etc.
    @Bean
    public GroupedOpenApi authAPI() {
        return GroupedOpenApi.builder().group("Authentication APIs").pathsToMatch("/admin/login/**", "/admin/info").build();
    }
}
