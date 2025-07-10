package com.etsia.common.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@Builder
@AllArgsConstructor
public class ChannelFollowerId implements Serializable {
    private static final long serialVersionUID = -5940579567290645672L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "channel_id", nullable = false)
    private Integer channelId;

    public ChannelFollowerId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChannelFollowerId entity = (ChannelFollowerId) o;
        return Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.channelId, entity.channelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, channelId);
    }

}