package com.etsia.post.domain.repository;

import java.util.UUID;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(UUID id);
    List<Post> findByAuthorId(UUID authorId);
    void delete(UUID id);

}