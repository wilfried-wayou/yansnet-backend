package com.etsia.auth.domain.model;

import java.util.Objects;

public class User {
    private final Integer userId;
    private final String email;
    private String phoneNumber;
    private String password;
    private boolean isActive;
    private boolean isBlocked;
    private int totalFollowers;
    private int totalFollowing;
    private int totalPosts;
    private Integer categoryId;
    private Integer departmentId;
    private Integer batchId;

    public User(Integer userId, String email, String password) {
        this.userId = Objects.requireNonNull(userId, "User ID cannot be null");
        this.email = validateEmail(email);
        this.password = Objects.requireNonNull(password, "Password cannot be null");
        this.isActive = true;
        this.isBlocked = false;
        this.totalFollowers = 0;
        this.totalFollowing = 0;
        this.totalPosts = 0;
    }

    public User(Integer userId, String email, String phoneNumber, String password,
                boolean isActive, boolean isBlocked, int totalFollowers, int totalFollowing,
                int totalPosts, Integer categoryId, Integer departmentId, Integer batchId) {
        this.userId = Objects.requireNonNull(userId, "User ID cannot be null");
        this.email = validateEmail(email);
        this.phoneNumber = phoneNumber;
        this.password = Objects.requireNonNull(password, "Password cannot be null");
        this.isActive = isActive;
        this.isBlocked = isBlocked;
        this.totalFollowers = Math.max(0, totalFollowers);
        this.totalFollowing = Math.max(0, totalFollowing);
        this.totalPosts = Math.max(0, totalPosts);
        this.categoryId = categoryId;
        this.departmentId = departmentId;
        this.batchId = batchId;
    }

    private String validateEmail(String email) {
        Objects.requireNonNull(email, "Email cannot be null");
        if (!email.contains("@") || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must be valid");
        }
        return email;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updatePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword, "Password cannot be null");
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void unblock() {
        this.isBlocked = false;
    }

    public void incrementFollowers() {
        this.totalFollowers++;
    }

    public void decrementFollowers() {
        if (this.totalFollowers > 0) {
            this.totalFollowers--;
        }
    }

    public void incrementFollowing() {
        this.totalFollowing++;
    }

    public void decrementFollowing() {
        if (this.totalFollowing > 0) {
            this.totalFollowing--;
        }
    }

    public void incrementPosts() {
        this.totalPosts++;
    }

    public void decrementPosts() {
        if (this.totalPosts > 0) {
            this.totalPosts--;
        }
    }

    public void updateCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void updateDepartment(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void updateBatch(Integer batchId) {
        this.batchId = batchId;
    }

    public boolean canAuthenticate() {
        return isActive && !isBlocked;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public int getTotalFollowers() {
        return totalFollowers;
    }

    public int getTotalFollowing() {
        return totalFollowing;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", isBlocked=" + isBlocked +
                '}';
    }
}