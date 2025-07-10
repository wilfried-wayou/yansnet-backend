package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.AuthService;
import com.etsia.auth.infrastructure.dto.AuthResponse;
import com.etsia.auth.infrastructure.dto.LoginRequest;
import com.etsia.auth.infrastructure.dto.RegisterRequest;
import com.etsia.auth.infrastructure.service.KeycloakAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthApplicationService {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final KeycloakAuthService keycloakAuthService;

    @Autowired
    public AuthApplicationService(AuthService authService, UserRepository userRepository, KeycloakAuthService keycloakAuthService) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.keycloakAuthService = keycloakAuthService;
    }

    public AuthResponse login(LoginRequest loginRequest) {
        User user = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (!user.canAuthenticate()) {
            throw new IllegalStateException("User account is inactive or blocked");
        }

        // Obtenir le token JWT depuis Keycloak
        String jwtToken = keycloakAuthService.getTokenFromKeycloak(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        if (jwtToken == null) {
            throw new IllegalStateException("Failed to obtain JWT token from Keycloak");
        }

        return new AuthResponse(
                user.getUserId(),
                user.getEmail(),
                jwtToken,
                "Bearer"
        );
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        User user = authService.register(
                registerRequest.getEmail(),
                registerRequest.getPassword(),
                registerRequest.getPhoneNumber()
        );

        // Obtenir le token JWT depuis Keycloak après l'inscription
        String jwtToken = keycloakAuthService.getTokenFromKeycloak(
                registerRequest.getEmail(),
                registerRequest.getPassword()
        );

        if (jwtToken == null) {
            throw new IllegalStateException("Failed to obtain JWT token from Keycloak after registration");
        }

        return new AuthResponse(
                user.getUserId(),
                user.getEmail(),
                jwtToken,
                "Bearer"
        );
    }

    public void logout(Integer userId) {
        authService.logout(userId);
    }

    public void changePassword(Integer userId, String oldPassword, String newPassword) {
        authService.changePassword(userId, oldPassword, newPassword);
    }
}