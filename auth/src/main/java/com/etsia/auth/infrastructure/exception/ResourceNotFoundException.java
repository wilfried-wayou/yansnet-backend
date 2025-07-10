package com.etsia.auth.infrastructure.exception;

public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String resource, String id) {
        super(resource + " avec l'identifiant " + id + " n'a pas été trouvé");
    }
}
