package com.etsia.common.domain.model;

import com.etsia.common.domain.model.sub.MessageType;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.etsia.common.infrastructure.entities.Message}
 */
@Value


@Builder
public class MessageDto implements Serializable {
    Integer id;
    String content;
    String url;
    ConversationDto conversation;
    UserDto user;
    MessageType type;
}