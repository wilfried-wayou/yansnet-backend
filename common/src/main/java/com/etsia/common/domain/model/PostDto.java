package com.etsia.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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