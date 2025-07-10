package com.etsia.auth.domain.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.infrastructure.repository.UserRepositoryImpl;

import lombok.AllArgsConstructor;

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
