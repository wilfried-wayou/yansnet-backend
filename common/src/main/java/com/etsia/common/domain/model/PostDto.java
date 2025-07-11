package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Post}
 */


@Builder
@Value
public class PostDto implements Serializable {
    Integer id;
    String content;
    Instant deletedAt;
    Instant createdAt;
    UserDto user;
    ChannelDto channel;
    int totalLikes;
    int totalComments;

}