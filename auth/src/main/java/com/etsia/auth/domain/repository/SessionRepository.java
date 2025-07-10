package com.etsia.auth.domain.repository;

import com.etsia.auth.domain.model.Session;
import com.etsia.auth.domain.model.dto.session.SignIn;
import com.etsia.auth.domain.model.dto.session.SignOut;
import com.etsia.auth.domain.model.dto.session.SignUp;

public interface SessionRepository {
    Session SignIn(SignIn signIn);
    Session SignUp(SignUp signUp);
    void SignOut(SignOut signOut);
}
