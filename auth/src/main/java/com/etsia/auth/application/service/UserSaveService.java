package com.etsia.auth.application.service;


import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.user.CreateUserDto;
import com.etsia.auth.domain.repository.UserRepository;
import com.etsia.auth.domain.service.UserDomainService;
import com.etsia.auth.infrastructure.exception.EmailAlreadyUsedException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    public User execute(CreateUserDto user){
        if(!userDomainService.IsEmailUnique(user.getEmail())){
            throw new EmailAlreadyUsedException("Email already used");
        }

        User user_profile = new User();
        user_profile.setEmail(user.getEmail());
        user_profile.setId(user.getId());
        return userRepository.Save(user_profile);
    }
}
