package com.etsia.auth.infrastructure.exception;

public class SessionExceptionRevoked extends RuntimeException {
    public SessionExceptionRevoked(String message) {
        super(message);
    }
}
