package com.etsia.interaction.infrastructure.adapters;

import com.etsia.common.infrastructure.entities.Channel;
import com.etsia.common.infrastructure.entities.ChannelFollower;
import com.etsia.common.infrastructure.entities.ChannelFollowerId;
import com.etsia.common.infrastructure.entities.User;
import com.etsia.interaction.domain.repository.ChannelFollowRepository;
import com.etsia.interaction.infrastructure.repository.JpaChannelFollowerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelFollowRepositoryImpl implements ChannelFollowRepository {
    private final JpaChannelFollowerRepository jpaChannelFollowerRepository;

    public ChannelFollowRepositoryImpl(JpaChannelFollowerRepository jpaChannelFollowerRepository) {
        this.jpaChannelFollowerRepository = jpaChannelFollowerRepository;
    }

    @Override
    public void follow(int followerId, int channelFollowerId) {
        try{
            System.out.println("Following " + channelFollowerId + " by " + followerId);
            jpaChannelFollowerRepository.save(ChannelFollower.builder()
                            .id(ChannelFollowerId.builder()
                                    .channelId(channelFollowerId)
                                    .userId(followerId)
                                    .build())
                            .channel(Channel.builder().id(channelFollowerId).build())
                            .user(User.builder().id(followerId).build())
                    .build());
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Follow already exists or user does not exist");


        }
    }

    @Override
    public void unfollow(int followerId, int channelFollowerId) {
        try{
            System.out.println("Unfollowing " + channelFollowerId + " by " + followerId);
            jpaChannelFollowerRepository.deleteById(ChannelFollowerId.builder()
                    .channelId(channelFollowerId)
                    .userId(followerId)
                    .build());
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Follow does not exist");
        }

    }

    @Override
    public boolean isFollowing(int followerId, int channelFollowerId) {
        try{
            return jpaChannelFollowerRepository.existsById(ChannelFollowerId.builder()
                    .channelId(channelFollowerId)
                    .userId(followerId)
                    .build());
        } catch (Exception e) {
            System.out.println(e);
            throw new IllegalArgumentException("Follow does not exist");
        }

    }
}
