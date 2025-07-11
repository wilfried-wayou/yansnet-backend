package com.etsia.interaction.domain.service;

import com.etsia.interaction.domain.repository.ChannelFollowRepository;
import org.springframework.stereotype.Service;

@Service
public class ChannelFollowDomainService {

    private final ChannelFollowRepository channelFollowRepository;

    public ChannelFollowDomainService(ChannelFollowRepository channelFollowRepository) {
        this.channelFollowRepository = channelFollowRepository;
    }

    public boolean isFollowing(Integer followerId, Integer followedId) {
        return channelFollowRepository.isFollowing(followerId, followedId);
    }
}
