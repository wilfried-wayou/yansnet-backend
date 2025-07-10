package com.etsia.user.domain.repository;

import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;

public interface UserRepository {
    User FindById(Integer id);
    User FindByEmail(String email);
    User Save(User user);
    Boolean existsByEmail(String email);
    User FindByEmailAndPassword(String email, String password);
    User update(UserUpdateDto user);
    void Delete(Integer id);
}
