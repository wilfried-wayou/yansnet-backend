package com.etsia.user.application.service;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignUp;
import com.etsia.user.domain.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SignUpSessionService {

    private final SessionRepository sessionRepository;
    //private final SessionDomainService sessionDomainService;

    public Session execute(SignUp signUp){
        return sessionRepository.SignUp(signUp);
    }


}
