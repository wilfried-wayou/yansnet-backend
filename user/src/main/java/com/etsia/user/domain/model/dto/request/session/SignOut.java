package com.etsia.user.domain.model.dto.request.session;

import com.etsia.user.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignOut {
    @NotBlank(message = "Token is required")
    private User user;
}
