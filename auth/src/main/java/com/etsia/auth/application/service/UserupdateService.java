package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserupdateService {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User exec(UserUpdateDto user){
        return userRepository.update(user);
    }
}
