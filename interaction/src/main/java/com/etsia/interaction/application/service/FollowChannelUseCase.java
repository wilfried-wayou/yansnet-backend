package com.etsia.interaction.application.service;

import com.etsia.interaction.domain.repository.ChannelFollowRepository;
import com.etsia.interaction.domain.service.ChannelFollowDomainService;
import org.springframework.stereotype.Service;

@Service
public class FollowChannelUseCase {
    private final ChannelFollowDomainService channelFollowDomainService;
    private final ChannelFollowRepository channelFollowRepository;
    public FollowChannelUseCase(ChannelFollowDomainService channelFollowDomainService, ChannelFollowRepository channelFollowRepository) {
        this.channelFollowDomainService = channelFollowDomainService;
        this.channelFollowRepository = channelFollowRepository;
    }

    public void execute(Integer channelId, Integer followerId) {
        if (channelFollowDomainService.isFollowing(channelId, followerId)) {
            throw new IllegalArgumentException("Follow already exists");
        }
        channelFollowRepository.follow(channelId, followerId);
    }
}
