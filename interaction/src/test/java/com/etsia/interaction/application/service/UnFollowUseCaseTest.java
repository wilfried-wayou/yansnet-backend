package com.etsia.interaction.application.service;

import com.etsia.interaction.domain.repository.FollowRepository;
import com.etsia.interaction.domain.service.FollowDomainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = UnFollowUseCase.class)
public class UnFollowUseCaseTest {

    @Mock
    private FollowDomainService followDomainService;

    @Mock
    private FollowRepository followRepository;

    @Autowired
    private UnFollowUseCase unFollowUseCase;

    /**
     * Test case: Verify no action is taken if the user is not following another user.
     */
    @Test
    public void testExecute_NotFollowing_NoActionTaken() {
        Integer followerId = 1;
        Integer followedId = 2;

        when(followDomainService.isFollowing(followerId, followedId)).thenReturn(false);

        unFollowUseCase.execute(followerId, followedId);

        verify(followDomainService, times(1)).isFollowing(followerId, followedId);
        verifyNoInteractions(followRepository);
    }

    /**
     * Test case: Verify unfollow is executed when the follower is following the followed user.
     */
    @Test
    public void testExecute_Following_UnfollowExecuted() {
        Integer followerId = 1;
        Integer followedId = 2;

        when(followDomainService.isFollowing(followerId, followedId)).thenReturn(true);

        unFollowUseCase.execute(followerId, followedId);

        verify(followDomainService, times(1)).isFollowing(followerId, followedId);
        verify(followRepository, times(1)).unfollow(followerId, followedId);
    }
}

