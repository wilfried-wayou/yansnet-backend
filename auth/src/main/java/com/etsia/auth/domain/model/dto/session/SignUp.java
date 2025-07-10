package com.etsia.auth.domain.model.dto.session;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUp extends SignIn {
    @NotBlank(message = "Phone Number is required")
    private String phonenumber;
}
