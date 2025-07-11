package com.etsia.common.domain.model;

import lombok.Builder;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.PostLike}
 */


@Builder
public class PostLikeDto implements Serializable {
    PostLikeIdDto id;
    UserDto user;
    PostDto post;
}