package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.CreateUserDto;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.EmailAlreadyUsedException;
import com.etsia.auth.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDelete {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public void execute(Integer id){
        try {
            userRepository.Delete(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User Not Found", id);
        }
    }
}
