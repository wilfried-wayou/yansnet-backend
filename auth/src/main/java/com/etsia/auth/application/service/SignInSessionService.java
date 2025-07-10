package com.etsia.auth.application.service;

import com.etsia.auth.domain.repository.SessionRepository;
import com.etsia.auth.domain.service.SessionDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public class SignInSessionService {
    private final SessionRepository sessionRepository;
    private final SessionDomainService sessionDomainService;

    public
}
