package com.etsia.auth.domain.model.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.auth.domain.model.User}
 */
@Getter
@Setter
@Value
public class CreateUserDto implements Serializable {
    @NotNull(message = "Id is required")
    Integer id;
    @NotBlank(message = "Email is required")
    String email;
    String phonenumber;
    @NotBlank
    String password;
    Boolean isactive;
    Boolean isblocked;
    Integer totalfollowers;
    Integer totalfollowing;
    Integer totalposts;
}