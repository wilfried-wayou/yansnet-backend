package com.etsia.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.UserCategory}
 */


@Builder
@Value
public class UserCategoryDto implements Serializable {
    Integer id;
    String name;
    String description;
}