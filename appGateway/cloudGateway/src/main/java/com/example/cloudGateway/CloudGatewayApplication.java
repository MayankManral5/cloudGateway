package com.example.cloudGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {
            System.out.println("First Global filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("Second Global filter");
            }));
        };
    }

}
