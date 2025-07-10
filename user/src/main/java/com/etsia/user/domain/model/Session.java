package com.etsia.user.domain.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "session")
public class Session {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "session_id", nullable = false)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "access_token", nullable = false, length = Integer.MAX_VALUE)
    private String accessToken;

    @Column(name = "refresh_token", length = Integer.MAX_VALUE)
    private String refreshToken;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @ColumnDefault("false")
    @Column(name = "revoked")
    private Boolean revoked;

}