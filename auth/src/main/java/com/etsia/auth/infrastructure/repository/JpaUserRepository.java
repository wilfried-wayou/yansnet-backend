package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User , Integer> {
    User findByEmail(String email);

    boolean existsByEmail(String email);
}
