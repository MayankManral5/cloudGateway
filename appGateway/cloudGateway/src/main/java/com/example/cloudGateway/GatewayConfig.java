package com.example.cloudGateway;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/employee/**")
                        .uri("http://localhost:8081/")
                )
                .route(p -> p
                        .path("/consumer/**")
                        .uri("http://localhost:8082/"))
                .build();

    }
}
