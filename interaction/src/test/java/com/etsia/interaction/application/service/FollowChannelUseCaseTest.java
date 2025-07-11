package com.etsia.interaction.application.service;

import com.etsia.interaction.domain.repository.ChannelFollowRepository;
import com.etsia.interaction.domain.service.ChannelFollowDomainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class FollowChannelUseCaseTest {

    @Autowired
    private UnFollowChannelUseCase unFollowChannelUseCase;

    @MockBean
    private ChannelFollowDomainService channelFollowDomainService;

    @MockBean
    private ChannelFollowRepository channelFollowRepository;

    @Test
    void shouldUnfollowWhenFollowExists() {
        Integer followerId = 1;
        Integer followedId = 2;

        when(channelFollowDomainService.isFollowing(followerId, followedId)).thenReturn(true);

        unFollowChannelUseCase.execute(followerId, followedId);

        verify(channelFollowRepository, times(1)).unfollow(followerId, followedId);
    }

    @Test
    void shouldThrowExceptionWhenFollowDoesNotExist() {
        Integer followerId = 1;
        Integer followedId = 2;

        when(channelFollowDomainService.isFollowing(followerId, followedId)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> unFollowChannelUseCase.execute(followerId, followedId));

        verify(channelFollowRepository, never()).unfollow(anyInt(), anyInt());
    }

    @Test
    void shouldFollowWhenNotFollowing() {
        Integer channelId = 1;
        Integer followerId = 2;

        when(channelFollowDomainService.isFollowing(channelId, followerId)).thenReturn(false);

        FollowChannelUseCase followChannelUseCase = new FollowChannelUseCase(channelFollowDomainService, channelFollowRepository);

        followChannelUseCase.execute(channelId, followerId);

        verify(channelFollowRepository, times(1)).follow(channelId, followerId);
    }


    @Test
    void shouldThrowExceptionWhenAlreadyFollowing() {
        Integer channelId = 1;
        Integer followerId = 2;

        when(channelFollowDomainService.isFollowing(channelId, followerId)).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () ->
                new FollowChannelUseCase(channelFollowDomainService, channelFollowRepository).execute(channelId, followerId)
        );

        verify(channelFollowRepository, never()).follow(anyInt(), anyInt());
    }
}