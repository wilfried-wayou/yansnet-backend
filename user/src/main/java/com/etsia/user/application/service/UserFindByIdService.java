package com.etsia.user.application.service;

import com.etsia.user.domain.model.User;
import com.etsia.user.domain.repository.UserRepository;
import com.etsia.user.domain.service.UserDomainService;
import com.etsia.user.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFindByIdService {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User exec(Integer id){
        if(!userDomainService.existsByEmail(id.toString())){
            throw new ResourceNotFoundException("User Not found", id);
        }

        return userRepository.FindById(id);
    }
}
