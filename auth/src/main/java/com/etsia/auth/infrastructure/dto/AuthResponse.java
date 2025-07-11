package com.etsia.auth.infrastructure.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {

    private Integer userId;
    private String email;
    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponse(Integer userId, String email, String accessToken, String tokenType) {
        this.userId = userId;
        this.email = email;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
}
