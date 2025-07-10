package com.etsia.user.domain.model.dto.request.user;


import com.etsia.common.domain.model.BatchDto;
import com.etsia.common.domain.model.DepartmentDto;
import com.etsia.common.domain.model.UserCategoryDto;
import com.etsia.common.domain.model.sub.Email;
import com.etsia.common.domain.model.sub.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;


@Builder
@Value
public class CreateUserDto implements Serializable {
    @NotNull(message = "Id is required")
    Integer id;
    @NotBlank(message = "Email is required")
    Email email;
    @NotBlank
    String password;
    Boolean isActive;
    UserCategoryDto category;
    Boolean isBlocked;
    DepartmentDto department;
    BatchDto batch;
    PhoneNumber phoneNumber;
    int totalFollowers;
    int totalFollowing;
    int totalPosts;
}