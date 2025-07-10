package com.etsia.user.infrastructure.controller;

import com.etsia.user.application.service.SignOutSessionService;
import com.etsia.user.application.service.SignUpSessionService;
import com.etsia.user.application.service.SignInSessionService;
import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignIn;
import com.etsia.user.domain.model.dto.request.session.SignOut;
import com.etsia.user.domain.model.dto.request.session.SignUp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
@AllArgsConstructor
public class SessionController {

    private final SignUpSessionService signUpSessionService;
    private final SignInSessionService signInSessionService;
    private final SignOutSessionService signOutSessionService;

    @PostMapping("/signin")
    public ResponseEntity<Session> signIn(@RequestBody SignIn signIn) {
        Session session = signInSessionService.execute(signIn);
        return ResponseEntity.ok(session);
    }

    @PostMapping("/signup")
    public ResponseEntity<Session> signUp(@RequestBody SignUp signUp) {
        Session session = signUpSessionService.execute(signUp);
        return ResponseEntity.ok(session);
    }

    @PostMapping("/signout")
    public ResponseEntity<Void> signOut(@RequestBody SignOut signOut) {
        signOutSessionService.execute(signOut);
        return ResponseEntity.noContent().build();
    }
}