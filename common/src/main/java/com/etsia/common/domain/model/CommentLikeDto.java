package com.etsia.common.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;
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