package com.etsia.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Comment}
 */

@Builder
@Value
public class CommentDto implements Serializable {
    Integer id;
    String content;
    Instant createdAt;
    Instant deletedAt;
    Boolean isDeleted;
    Boolean isEdited;
    Instant updatedAt;
    PostDto post;
    UserDto user;
    CommentDto replyToComment;
    int totalLikes;
}