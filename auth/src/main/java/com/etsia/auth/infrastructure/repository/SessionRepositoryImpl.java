package com.etsia.auth.infrastructure.repository;

import com.etsia.auth.domain.model.Session;
import com.etsia.auth.domain.model.User;
import com.etsia.auth.domain.model.dto.request.session.SignIn;
import com.etsia.auth.domain.model.dto.request.session.SignOut;
import com.etsia.auth.domain.model.dto.request.session.SignUp;
import com.etsia.auth.domain.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SessionRepositoryImpl implements SessionRepository {

    private final JpaSessionRepository jpaSessionRepository;
    private final UserRepositoryImpl userRepositoryImpl;

    @Override
    public Session SignIn(SignIn signIn) {
        User user = userRepositoryImpl.FindByEmailAndPassword(signIn.getEmail(), signIn.getPassword());
        return null;
    }

    @Override
    public Session SignUp(SignUp signUp) {
        User user = userRepositoryImpl.FindByEmail(signUp.getEmail());
        Session user_session = new Session();
        user_session.setUser(user);
        return jpaSessionRepository.save(user_session);
    }

    @Override
    public void SignOut(SignOut signOut) {
        Session user_session = jpaSessionRepository.findByUser(signOut.getUser());
        user_session.setRevoked(true);
        jpaSessionRepository.save(user_session);
    }
}
