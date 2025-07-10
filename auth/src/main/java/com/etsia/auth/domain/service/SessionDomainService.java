package com.etsia.auth.domain.service;

import com.etsia.auth.infrastructure.repository.SessionRepositoryImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SessionDomainService {

    private final SessionRepositoryImpl sessionRepositoryImpl;

}
