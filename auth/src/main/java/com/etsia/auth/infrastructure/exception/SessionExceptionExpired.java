package com.etsia.auth.infrastructure.exception;

public class SessionExceptionExpired extends RuntimeException {
    public SessionExceptionExpired(String message) {
        super(message);
    }
}
