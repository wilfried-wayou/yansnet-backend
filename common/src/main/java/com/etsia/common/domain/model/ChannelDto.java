package com.etsia.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
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