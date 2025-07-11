package com.etsia.common.domain.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.PostLikeId}
 */


@Builder
public class PostLikeIdDto implements Serializable {
    Integer userId;
    Integer postId;
}