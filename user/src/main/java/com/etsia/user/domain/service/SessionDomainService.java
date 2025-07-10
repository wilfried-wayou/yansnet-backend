package com.etsia.user.domain.service;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignIn;
import com.etsia.user.domain.model.dto.request.session.SignOut;
import com.etsia.user.domain.model.dto.request.session.SignUp;
import com.etsia.user.domain.repository.SessionRepository;
import com.etsia.user.infrastructure.repository.SessionRepositoryImpl;
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
