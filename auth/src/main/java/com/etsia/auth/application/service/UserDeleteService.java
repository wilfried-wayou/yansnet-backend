package com.etsia.auth.application.service;

import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDeleteService {

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
