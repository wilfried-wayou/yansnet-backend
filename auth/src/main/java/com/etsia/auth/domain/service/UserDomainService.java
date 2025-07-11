package com.etsia.auth.domain.service;

import com.etsia.auth.domain.model.AuthUser;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {

    public void updatePhoneNumber(AuthUser user, String phoneNumber) {
        user.updatePhoneNumber(phoneNumber != null ? new com.etsia.common.domain.model.sub.PhoneNumber(phoneNumber) : null);
    }

    public void updatePassword(AuthUser user, String newPassword) {
        user.updatePassword(newPassword);
    }

    public void activateUser(AuthUser user) {
        user.activate();
    }

    public void deactivateUser(AuthUser user) {
        user.deactivate();
    }

    public void blockUser(AuthUser user) {
        user.block();
    }

    public void unblockUser(AuthUser user) {
        user.unblock();
    }

    public void incrementFollowers(AuthUser user) {
        user.incrementFollowers();
    }

    public void decrementFollowers(AuthUser user) {
        user.decrementFollowers();
    }

    public void incrementFollowing(AuthUser user) {
        user.incrementFollowing();
    }

    public void decrementFollowing(AuthUser user) {
        user.decrementFollowing();
    }

    public void incrementPosts(AuthUser user) {
        user.incrementPosts();
    }

    public void decrementPosts(AuthUser user) {
        user.decrementPosts();
    }

    public void updateCategory(AuthUser user, Integer categoryId) {
        user.updateCategory(categoryId);
    }

    public void updateDepartment(AuthUser user, Integer departmentId) {
        user.updateDepartment(departmentId);
    }

    public void updateBatch(AuthUser user, Integer batchId) {
        user.updateBatch(batchId);
    }

    public boolean canAuthenticate(AuthUser user) {
        return user.canAuthenticate();
    }
}