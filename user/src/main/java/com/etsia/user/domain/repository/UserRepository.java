package com.etsia.user.domain.repository;

import com.etsia.common.domain.model.UserDto;
import com.etsia.common.domain.model.sub.Email;
import com.etsia.user.domain.model.dto.request.user.CreateUserDto;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;

import java.util.Optional;

public interface UserRepository {
    Optional<UserDto> FindById(Integer id);
    Optional<UserDto> FindByEmail(Email email);
    UserDto Save(CreateUserDto user);
    Boolean existsByEmail(Email email);
    Optional<UserDto> FindByEmailAndPassword(Email email, String password);
    UserDto update(UserUpdateDto user);
    void Delete(Integer id);
}
