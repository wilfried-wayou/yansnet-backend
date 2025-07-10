package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User FindById(Integer id) {
        return jpaUserRepository.findById(id).orElse(null);
    }

    @Override
    public User FindByEmail(String email) {
        return jpaUserRepository.findByEmail(email);
    }

    @Override
    public void Save(User user) {
        jpaUserRepository.save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public User FindByEmailAndPassword(String email, String password) {
        User user_profile = jpaUserRepository.findByEmail(email);
        if (user_profile != null && user_profile.getPassword().equals(password)) { throw new RuntimeException("User not found");}
        return user_profile;
    }
}
