package com.etsia.post.infrastructure.repository;

import com.etsia.common.infrastructure.entities.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findAll(Pageable pageable);
}
