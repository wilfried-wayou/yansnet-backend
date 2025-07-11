package com.etsia.interaction.application.service;

import com.etsia.interaction.domain.repository.FollowRepository;
import com.etsia.interaction.domain.service.FollowDomainService;
import org.springframework.stereotype.Service;

@Service
public class FollowUseCase {

    private final FollowDomainService followDomainService;
    private final FollowRepository followRepository;

    public FollowUseCase(FollowDomainService followDomainService, FollowRepository followRepository) {
        this.followDomainService = followDomainService;
        this.followRepository = followRepository;
    }

    public void execute(Integer followerId, Integer followedId) {
        if(followDomainService.isFollowing(followerId, followedId)) {
            throw new IllegalArgumentException("Follow already exists");
        }
        followRepository.follow(followerId, followedId);
    }
}
