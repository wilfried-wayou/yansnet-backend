package com.etsia.user.domain.service;

import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.user.domain.repository.UserRepository;
import com.etsia.user.infrastructure.repository.UserRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDomainService implements UserRepository {

    private final UserRepositoryImpl userRepositoryImpl;

    public Boolean IsEmailUnique(String email){
        return !userRepositoryImpl.existsByEmail(email);
    }

    @Override
    public User FindById(Integer id) {
        return userRepositoryImpl.FindById(id);
    }

    @Override
    public User FindByEmail(String email) {
        return userRepositoryImpl.FindByEmail(email);
    }

    @Override
    public User Save(User user) {
        return userRepositoryImpl.Save(user);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return !userRepositoryImpl.existsByEmail(email);
    }

    @Override
    public User FindByEmailAndPassword(String email, String password) {
        return userRepositoryImpl.FindByEmailAndPassword(email, password);
    }

    @Override
    public User update(UserUpdateDto user) {
        return userRepositoryImpl.update(user);
    }

    @Override
    public void Delete(Integer id) {
        userRepositoryImpl.Delete(id);
    }
}
