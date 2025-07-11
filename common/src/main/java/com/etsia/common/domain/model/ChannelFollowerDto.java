package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.ChannelFollower}
 */


@Builder
@Value
public class ChannelFollowerDto implements Serializable {
    ChannelFollowerIdDto id;
    UserDto user;
    ChannelDto channel;
}