package com.etsia.auth.infrastructure.controller;

import com.etsia.auth.application.service.AuthApplicationService;
import com.etsia.auth.infrastructure.dto.AuthResponse;
import com.etsia.auth.infrastructure.dto.LoginRequest;
import com.etsia.auth.infrastructure.dto.LogoutRequest;
import com.etsia.auth.infrastructure.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthApplicationService authApplicationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = authApplicationService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        AuthResponse response = authApplicationService.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@Valid @RequestBody LogoutRequest request) {
        authApplicationService.logout(request.getUserId());
        return ResponseEntity.ok().build();
    }
}
