package com.etsia.common.domain.model;

import lombok.Builder;
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