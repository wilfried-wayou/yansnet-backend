package com.etsia.auth.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phonenumber", length = 50)
    private String phonenumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isactive")
    private Boolean isactive;

    @Column(name = "isblocked")
    private Boolean isblocked;

    @Column(name = "totalfollowers")
    private Integer totalfollowers;

    @Column(name = "totalfollowing")
    private Integer totalfollowing;

    @Column(name = "totalposts")
    private Integer totalposts;

}