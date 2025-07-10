package com.etsia.user.domain.repository;

import com.etsia.user.domain.model.Session;
import com.etsia.user.domain.model.dto.request.session.SignIn;
import com.etsia.user.domain.model.dto.request.session.SignOut;
import com.etsia.user.domain.model.dto.request.session.SignUp;

public interface SessionRepository {
    Session SignIn(SignIn signIn);
    Session SignUp(SignUp signUp);
    void SignOut(SignOut signOut);
}
