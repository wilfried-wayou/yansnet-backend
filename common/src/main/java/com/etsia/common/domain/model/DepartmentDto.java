package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Department}
 */

@Builder
@Value
public class DepartmentDto implements Serializable {
    Integer id;
    String name;
}