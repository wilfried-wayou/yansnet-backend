package com.etsia.auth.infrastructure.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LogoutRequest {

    @NotNull(message = "User ID is required")
    private Integer userId;
}
