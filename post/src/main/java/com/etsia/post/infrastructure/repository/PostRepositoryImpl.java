package com.etsia.post.infrastructure.repository;

import com.etsia.common.domain.model.PostDto;
import com.etsia.common.infrastructure.config.Mapper;
import com.etsia.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public PostDto save(PostDto post) {
        return null;
    }

    @Override
    public Optional<PostDto> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<PostDto> findByAuthorId(Integer authorId) {
        return List.of();
    }

    @Override
    public void delete(Integer id) {
        jpaPostRepository.deleteById(id);
    }

    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        return jpaPostRepository.findAll(pageable).map(Mapper::toPostDto);
    }
}
