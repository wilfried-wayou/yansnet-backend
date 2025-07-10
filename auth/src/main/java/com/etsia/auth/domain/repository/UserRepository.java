package com.etsia.auth.domain.repository;

import com.etsia.auth.domain.model.User;

public interface UserRepository {
    User FindById(Integer id);
    User FindByEmail(String email);
    void Save(User user);
    Boolean existsByEmail(String email);
    User FindByEmailAndPassword(String email, String password);
}
