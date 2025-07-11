package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.AuthUser;
import com.etsia.auth.domain.model.UserMapper;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.common.domain.model.sub.Email;
import com.etsia.common.infrastructure.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public AuthUser save(AuthUser user) {
        User entity = userMapper.toEntity(user);
        User savedEntity = jpaUserRepository.save(entity);
        return userMapper.toDomainModel(savedEntity);
    }

    @Override
    public Optional<AuthUser> findById(Integer userId) {
        return jpaUserRepository.findById(userId)
                .map(userMapper::toDomainModel);
    }

    @Override
    public Optional<AuthUser> findByEmail(Email email) {
        return jpaUserRepository.findByEmail(email)
                .map(userMapper::toDomainModel);
    }

    @Override
    public boolean existsByEmail(Email email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public void delete(AuthUser user) {
        jpaUserRepository.deleteById(user.getUserId());
    }

    @Override
    public void deleteById(Integer userId) {
        jpaUserRepository.deleteById(userId);
    }
}