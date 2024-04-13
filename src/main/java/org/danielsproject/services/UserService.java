package org.danielsproject.services;

import org.danielsproject.dtos.request.UserLoginRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.model.User;

import java.util.Optional;

public interface UserService {

    User createUser(UserRegistrationRequest request);

    void login(UserLoginRequest userLoginRequest);

    Optional<User> findUser(User user);

}
