package com.etsia.user.domain.service;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignIn;
import com.etsia.user.domain.model.dto.request.session.SignOut;
import com.etsia.user.domain.model.dto.request.session.SignUp;
import com.etsia.user.domain.repository.SessionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SessionDomainService  {

    private final SessionRepository sessionRepository;

    public Session SignIn(SignIn signIn) {
        return sessionRepository.SignIn(signIn);
    }

    public Session SignUp(SignUp signUp) {
        return sessionRepository.SignUp(signUp);
    }

    public void SignOut(SignOut signOut) {
        sessionRepository.SignOut(signOut);
    }
}
