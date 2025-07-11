package com.etsia.interaction.infrastructure.repository;

import com.etsia.common.infrastructure.entities.UserFollow;
import com.etsia.common.infrastructure.entities.UserFollowId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserFollowRepository extends JpaRepository<UserFollow, UserFollowId>, JpaSpecificationExecutor<UserFollow> {

  @Query("select exists(select 1 from UserFollow where follower.id = :followerId and followed.id = :followedId)")
  boolean existsByFollowerIdAndFollowedId(Integer followerId, Integer followedId);

}