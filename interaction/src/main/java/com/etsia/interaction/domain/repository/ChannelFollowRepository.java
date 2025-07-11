package com.etsia.interaction.domain.repository;

import com.etsia.common.infrastructure.entities.ChannelFollowerId;

public interface ChannelFollowRepository {

    void follow(int followerId, int channelFollowerId);

    void unfollow(int followerId, int channelFollowerId);

    boolean isFollowing(int followerId, int channelFollowerId);
}
