package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Channel}
 */
@Builder
@Value
public class ChannelDto implements Serializable {
    Integer id;
    String title;
    String description;
    int totalFollowers;

}