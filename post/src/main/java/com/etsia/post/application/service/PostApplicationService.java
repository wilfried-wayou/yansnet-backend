package com.etsia.post.application.service;

import com.etsia.common.domain.model.PostDto;
import com.etsia.post.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostApplicationService {
    private final PostService postService;

    public Page<PostDto> getAllPosts(Pageable pageable) {
        return postService.getAllPosts(pageable);
    }

    public void deletePost(Integer id) {
        postService.deletePost(id);
    }

}
