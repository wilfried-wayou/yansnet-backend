package com.etsia.common.infrastructure.entities;

import com.etsia.common.domain.model.sub.ConversationRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "channel_users", schema = "public")
public class ChannelUser {
    @EmbeddedId
    private ChannelUserId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @MapsId("channelId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "conversation_role not null")
    private ConversationRole role;
}