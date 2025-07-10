package com.etsia.user.application.service;

import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.UserUpdateDto;
import com.etsia.user.domain.repository.UserRepository;
import com.etsia.user.domain.service.UserDomainService;
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
