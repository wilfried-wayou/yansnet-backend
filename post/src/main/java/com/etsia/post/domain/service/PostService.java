package com.etsia.post.domain.service;

import com.etsia.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(UUID authorId, String content) {
        Post post = new Post(authorId, content);
        return postRepository.save(post);
    }
}