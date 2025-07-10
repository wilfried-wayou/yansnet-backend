package com.etsia.auth.infrastructure.repository;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "keycloak_user_mapping")
public class KeycloakUserMappingEntity {
    
    @Id
    @Column(name = "internal_user_id")
    private Integer internalUserId;
    
    @Column(name = "keycloak_user_id", unique = true, nullable = false, length = 36)
    private String keycloakUserId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    public KeycloakUserMappingEntity() {
        this.createdAt = LocalDateTime.now();
    }
    
    public KeycloakUserMappingEntity(Integer internalUserId, String keycloakUserId) {
        this.internalUserId = internalUserId;
        this.keycloakUserId = keycloakUserId;
        this.createdAt = LocalDateTime.now();
    }

    public Integer getInternalUserId() {
        return internalUserId;
    }

    public void setInternalUserId(Integer internalUserId) {
        this.internalUserId = internalUserId;
    }

    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}