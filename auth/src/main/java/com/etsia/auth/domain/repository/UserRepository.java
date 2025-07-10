package com.etsia.auth.domain.repository;

import com.etsia.auth.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Integer userId);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    void delete(User user);

    void deleteById(Integer userId);
}