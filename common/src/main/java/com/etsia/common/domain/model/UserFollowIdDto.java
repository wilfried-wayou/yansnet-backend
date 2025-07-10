package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.UserFollowId}
 */
@Value
@Builder
public class UserFollowIdDto implements Serializable {
    Integer followerId;
    Integer followedId;
}