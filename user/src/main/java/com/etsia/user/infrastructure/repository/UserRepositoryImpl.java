package com.etsia.user.infrastructure.repository;


import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.user.domain.repository.UserRepository;
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
    public User Save(User user) {
        return jpaUserRepository.save(user);
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

    @Override
    public User update(UserUpdateDto user) {
        User user_update = new User();
        user_update.setId(user.getId());
        user_update.setEmail(user.getEmail());
        user_update.setPassword(user.getPassword());
        return jpaUserRepository.save(user_update);
    }

    @Override
    public void Delete(Integer id) {
        jpaUserRepository.deleteById(id);
    }
}
