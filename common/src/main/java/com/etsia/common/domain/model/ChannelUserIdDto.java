package com.etsia.common.domain.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.ChannelUserId}
 */


@Builder
public class ChannelUserIdDto implements Serializable {
    Integer userId;
    Integer channelId;
}