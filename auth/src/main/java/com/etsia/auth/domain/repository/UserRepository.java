package com.etsia.auth.domain.repository;

import com.etsia.auth.domain.model.AuthUser;
import com.etsia.common.domain.model.sub.Email;

import java.util.Optional;

public interface UserRepository {
    AuthUser save(AuthUser user);

    Optional<AuthUser> findById(Integer userId);

    Optional<AuthUser> findByEmail(Email email);

    boolean existsByEmail(Email email);

    void delete(AuthUser user);

    void deleteById(Integer userId);
}