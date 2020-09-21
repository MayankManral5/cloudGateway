package com.example.cloudGateway.controller;

import com.example.cloudGateway.domain.AuthRequest;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${keycloak.auth-server-url}")
    private String SERVER_URL;
    @Value("${keycloak.realm}")
    private String REALM;
    @Value("${keycloak.resource}")
    private String CLIENT_ID;

    @PostMapping("/login")
    public String getDomain(@RequestBody @Valid AuthRequest authRequest) {

        Keycloak keycloak = KeycloakBuilder
                .builder()
                .serverUrl(SERVER_URL)
                .realm(REALM)
                .username(authRequest.getUsername())
                .password(authRequest.getPassword())
                .clientId(CLIENT_ID)
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                .build();

        try {
            AccessTokenResponse accessToken = keycloak.tokenManager().getAccessToken();
            return accessToken.getToken();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
