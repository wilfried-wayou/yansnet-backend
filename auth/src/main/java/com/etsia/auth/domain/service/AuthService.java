package com.etsia.auth.domain.service;

import com.etsia.auth.domain.model.User;

public interface AuthService {
    User authenticate(String email, String password);

    User register(String email, String password, String phoneNumber);

    void logout(Integer userId);

    boolean isValidCredentials(String email, String password);

    void changePassword(Integer userId, String oldPassword, String newPassword);
}