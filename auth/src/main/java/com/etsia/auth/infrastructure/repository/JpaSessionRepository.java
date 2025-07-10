package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.Session;
import com.etsia.auth.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JpaSessionRepository extends JpaRepository<Session, UUID> {

    List<Session> findByUser(User user);

    Session findByUser(User user);
}
