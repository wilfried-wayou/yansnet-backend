package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.CommentLike}
 */


@Builder
@Value
public class CommentLikeDto implements Serializable {
    CommentLikeIdDto id;
    UserDto user;
    CommentDto comment;
}