package org.danielsproject.services;

import org.danielsproject.dtos.request.UserLoginRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.exceptions.DuplicateModelException;
import org.danielsproject.exceptions.RegistrationFailedException;
import org.danielsproject.model.User;

import java.util.Optional;

public interface UserService {
    UserRegistrationResponse createUser(UserRegistrationRequest request) throws RegistrationFailedException, DuplicateModelException;

    void login(UserLoginRequest userLoginRequest);

    Optional<User> findUser(User user);

    void deleteAll();

    boolean existsByEmail(String email);
}
