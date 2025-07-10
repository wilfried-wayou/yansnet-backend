package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
public class UserFindById {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User exec(Integer id){
        if(!userDomainService.existsByEmail(id.toString())){
            throw new ResourceNotFoundException("User Not found", id);
        }

        return userRepository.FindById(id);
    }
}
