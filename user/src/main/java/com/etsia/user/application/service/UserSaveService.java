package com.etsia.user.application.service;


import com.etsia.user.domain.model.User;
import com.etsia.user.domain.model.dto.request.user.CreateUserDto;
import com.etsia.user.domain.repository.UserRepository;
import com.etsia.user.domain.service.UserDomainService;
import com.etsia.user.infrastructure.exception.EmailAlreadyUsedException;
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
