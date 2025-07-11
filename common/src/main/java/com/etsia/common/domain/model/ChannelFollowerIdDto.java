package com.etsia.common.domain.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.ChannelFollowerId}
 */


@Builder
public class ChannelFollowerIdDto implements Serializable {
    Integer userId;
    Integer channelId;
}