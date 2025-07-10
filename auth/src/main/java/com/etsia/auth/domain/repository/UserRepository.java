package com.etsia.auth.domain.repository;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.CreateUserDto;
import com.etsia.auth.domain.model.dto.request.user.UserUpdateDto;

public interface UserRepository {
    User FindById(Integer id);
    User FindByEmail(String email);
    User Save(User user);
    Boolean existsByEmail(String email);
    User FindByEmailAndPassword(String email, String password);
    User update(UserUpdateDto user);
    void Delete(Integer id);
}
