package com.etsia.user.infrastructure.repository;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSessionRepository extends JpaRepository<Session, UUID> {

    //List<Session> findByUser(User user);
    Session findByUser(User user);
}
