package com.etsia.common.domain.model;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.UserFollow}
 */
@Value
@Builder

public class UserFollowDto implements Serializable {
    UserFollowIdDto id;
    UserDto follower;
    UserDto followed;
}