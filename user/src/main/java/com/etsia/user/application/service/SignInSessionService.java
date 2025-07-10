package com.etsia.user.application.service;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignIn;
import com.etsia.user.domain.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignInSessionService {
    private final SessionRepository sessionRepository;
    //private final SessionDomainService sessionDomainService;

    public Session execute(SignIn signIn){
        return sessionRepository.SignIn(signIn);
    }

}
