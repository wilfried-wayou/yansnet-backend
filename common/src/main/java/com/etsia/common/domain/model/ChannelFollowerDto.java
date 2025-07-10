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
 * DTO for {@link com.etsia.common.infrastructure.entities.ChannelFollower}
 */


@Builder
@Value
public class ChannelFollowerDto implements Serializable {
    ChannelFollowerIdDto id;
    UserDto user;
    ChannelDto channel;
}