package com.etsia.common.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ChannelUserId implements Serializable {
    private static final long serialVersionUID = -5609957542799826960L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "channel_id", nullable = false)
    private Integer channelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChannelUserId entity = (ChannelUserId) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, channelId);
    }

}