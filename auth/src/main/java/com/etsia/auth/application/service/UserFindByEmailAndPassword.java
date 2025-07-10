package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.EmailNotFoundException;
import com.etsia.auth.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFindByEmailAndPassword {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User exec(String Email, String password){
        if(!userDomainService.existsByEmail(Email)){
            throw new EmailNotFoundException("User not found");
        }

        return userRepository.FindByEmailAndPassword(Email, password);
    }
}
