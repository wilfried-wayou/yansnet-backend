package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        UserEntity savedEntity = jpaUserRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return jpaUserRepository.findById(userId)
                .map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public void delete(User user) {
        jpaUserRepository.deleteById(user.getUserId());
    }

    @Override
    public void deleteById(Integer userId) {
        jpaUserRepository.deleteById(userId);
    }

    private UserEntity toEntity(User user) {
        return new UserEntity(
                user.getUserId(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.isActive(),
                user.isBlocked(),
                user.getTotalFollowers(),
                user.getTotalFollowing(),
                user.getTotalPosts(),
                user.getCategoryId(),
                user.getDepartmentId(),
                user.getBatchId()
        );
    }

    private User toDomain(UserEntity entity) {
        return new User(
                entity.getUserId(),
                entity.getEmail(),
                entity.getPhoneNumber(),
                entity.getPassword(),
                entity.getIsActive(),
                entity.getIsBlocked(),
                entity.getTotalFollowers(),
                entity.getTotalFollowing(),
                entity.getTotalPosts(),
                entity.getCategoryId(),
                entity.getDepartmentId(),
                entity.getBatchId()
        );
    }
}