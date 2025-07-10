package com.etsia.auth.domain.service;

import com.etsia.auth.domain.model.Session;
import com.etsia.auth.domain.model.dto.request.session.SignIn;
import com.etsia.auth.domain.model.dto.request.session.SignOut;
import com.etsia.auth.domain.model.dto.request.session.SignUp;
import com.etsia.auth.domain.repository.SessionRepository;
import com.etsia.auth.infrastructure.repository.SessionRepositoryImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SessionDomainService implements SessionRepository {

    private final SessionRepositoryImpl sessionRepositoryImpl;

    @Override
    public Session SignIn(SignIn signIn) {
        return sessionRepositoryImpl.SignIn(signIn);
    }

    @Override
    public Session SignUp(SignUp signUp) {
        return sessionRepositoryImpl.SignUp(signUp);
    }

    @Override
    public void SignOut(SignOut signOut) {
        sessionRepositoryImpl.SignOut(signOut);
    }
}
