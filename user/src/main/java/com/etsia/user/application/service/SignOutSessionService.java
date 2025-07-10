package com.etsia.user.application.service;

import com.etsia.user.domain.model.dto.request.session.SignOut;
import com.etsia.user.domain.repository.SessionRepository;
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
