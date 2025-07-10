package com.etsia.auth.infrastructure.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_blocked")
    private Boolean isBlocked = false;

    @Column(name = "total_followers")
    private Integer totalFollowers = 0;

    @Column(name = "total_following")
    private Integer totalFollowing = 0;

    @Column(name = "total_posts")
    private Integer totalPosts = 0;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "batch_id")
    private Integer batchId;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String email, String phoneNumber, String password,
                      Boolean isActive, Boolean isBlocked, Integer totalFollowers,
                      Integer totalFollowing, Integer totalPosts, Integer categoryId,
                      Integer departmentId, Integer batchId) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.isActive = isActive;
        this.isBlocked = isBlocked;
        this.totalFollowers = totalFollowers;
        this.totalFollowing = totalFollowing;
        this.totalPosts = totalPosts;
        this.categoryId = categoryId;
        this.departmentId = departmentId;
        this.batchId = batchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Integer getTotalFollowers() {
        return totalFollowers;
    }

    public void setTotalFollowers(Integer totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

    public Integer getTotalFollowing() {
        return totalFollowing;
    }

    public void setTotalFollowing(Integer totalFollowing) {
        this.totalFollowing = totalFollowing;
    }

    public Integer getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(Integer totalPosts) {
        this.totalPosts = totalPosts;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }
}