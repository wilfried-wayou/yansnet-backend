package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.EmailNotFoundException;
import com.etsia.auth.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserFindByEmail {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User exec(String Email){
        if(!userDomainService.existsByEmail(Email)){
            throw new EmailNotFoundException("Email Not found");
        }

        return userRepository.FindByEmail(Email);
    }
}
