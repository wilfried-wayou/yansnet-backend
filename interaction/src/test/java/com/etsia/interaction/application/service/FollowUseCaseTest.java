package com.etsia.interaction.application.service;

import com.etsia.interaction.domain.repository.FollowRepository;
import com.etsia.interaction.domain.service.FollowDomainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBeans;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FollowUseCaseTest {

    @Autowired
    private FollowUseCase followUseCase;

    @MockBean
    private FollowDomainService followDomainService;

    @MockBean
    private FollowRepository followRepository;

    /**
     * Tests that when a user is already following another user, the follow action is not performed.
     */
    @Test
    void execute_doesNothing_whenAlreadyFollowing() {
        // Arrange
        Integer followerId = 1;
        Integer followedId = 2;

        when(followDomainService.isFollowing(followerId, followedId)).thenReturn(true);

        // Act
        followUseCase.execute(followerId, followedId);

        // Assert
        verify(followRepository, never()).follow(anyInt(), anyInt());
    }

    /**
     * Tests that when a user is not already following another user, the follow action is performed.
     */
    @Test
    void execute_followsUser_whenNotAlreadyFollowing() {
        // Arrange
        Integer followerId = 1;
        Integer followedId = 2;

        when(followDomainService.isFollowing(followerId, followedId)).thenReturn(false);

        // Act
        followUseCase.execute(followerId, followedId);

        // Assert
        verify(followRepository, times(1)).follow(followerId, followedId);
    }
}