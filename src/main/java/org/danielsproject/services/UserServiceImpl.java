package org.danielsproject.services;

import lombok.AllArgsConstructor;
import org.danielsproject.dtos.request.UserLoginRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.exceptions.InvalidDetailsException;
import org.danielsproject.exceptions.UserNotFoundException;
import org.danielsproject.model.User;
import org.danielsproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User createUser(UserRegistrationRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
//        User foundUser = userRepository.findByEmail(userLoginRequest.getEmail());
//        if(!userExist(userLoginRequest.getEmail())) throw new InvalidDetailsException();
//        if(!foundUser.getPassword().equals(userLoginRequest.getPassword()))throw new InvalidDetailsException();
//        userRepository.save(foundUser);
       Optional<User> user = validateUserLogin(userLoginRequest.getEmail(), userLoginRequest.getPassword());

    }


    private Optional<User> validateUserLogin(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)){
            return user;
        }
        throw new InvalidDetailsException();
    }


    @Override
    public Optional<User> findUser(User user) {
        Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
        if (foundUser.isPresent()) {
            return foundUser;
        }
        throw new UserNotFoundException("User not found");
    }
}
