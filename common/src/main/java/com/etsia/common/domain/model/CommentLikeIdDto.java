package com.etsia.common.domain.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.CommentLikeId}
 */


@Builder
public class CommentLikeIdDto implements Serializable {
    Integer userId;
    Integer commentId;
}