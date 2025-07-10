package com.etsia.common.domain.model;

import com.etsia.common.domain.model.sub.ConversationRole;
import lombok.Builder;


import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.ChannelUser}
 */


@Builder
public class ChannelUserDto implements Serializable {
    ChannelUserIdDto id;
    UserDto user;
    ChannelDto channel;
    ConversationRole role;
}