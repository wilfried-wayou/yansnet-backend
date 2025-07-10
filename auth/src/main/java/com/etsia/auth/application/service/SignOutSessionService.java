package com.etsia.auth.application.service;

import com.etsia.auth.domain.model.Session;
import com.etsia.auth.domain.model.dto.request.session.SignOut;
import com.etsia.auth.domain.model.dto.request.session.SignUp;
import com.etsia.auth.domain.repository.SessionRepository;
import com.etsia.auth.domain.service.SessionDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignOutSessionService {
    private final SessionRepository sessionRepository;
    //private final SessionDomainService sessionDomainService;

    public void execute(SignOut signOut){
        sessionRepository.SignOut(signOut);
    }
}
