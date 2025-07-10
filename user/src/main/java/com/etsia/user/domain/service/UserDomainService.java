package com.etsia.user.domain.service;

import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDomainService {

    private final UserRepository userRepository;

    public Boolean IsEmailUnique(String email){
        return !userRepository.existsByEmail(email);
    }

    public User FindById(Integer id) {
        return userRepository.FindById(id);
    }

    public User FindByEmail(String email) {
        return userRepository.FindByEmail(email);
    }

    public User Save(User user) {
        return userRepository.Save(user);
    }

    public Boolean existsByEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    public User FindByEmailAndPassword(String email, String password) {
        return userRepository.FindByEmailAndPassword(email, password);
    }

    public User update(UserUpdateDto user) {
        return userRepository.update(user);
    }

    public void Delete(Integer id) {
        userRepository.Delete(id);
    }
}
