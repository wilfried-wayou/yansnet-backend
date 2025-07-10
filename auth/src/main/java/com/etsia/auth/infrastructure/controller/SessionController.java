package com.etsia.auth.infrastructure.controller;

import com.etsia.auth.application.service.UserFindById;
import com.etsia.auth.application.service.UserSave;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class SessionController {

    private final UserSave createUserService;
    private final UserFindById findByIdService;
}
