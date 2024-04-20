package org.danielsproject.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.request.UserLoginRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.exceptions.InvalidDetailsException;
import org.danielsproject.exceptions.RegistrationFailedException;
import org.danielsproject.exceptions.UserNotFoundException;
import org.danielsproject.model.User;
import org.danielsproject.repository.UserRepository;
import org.danielsproject.services.notification.MailService;
import org.danielsproject.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static org.danielsproject.utils.Constants.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private Validator validator;
    private MailService mailService;
    private EventService eventService;


    @Override
    public UserRegistrationResponse createUser(UserRegistrationRequest request) throws RegistrationFailedException {
        try{
            Set<ConstraintViolation<UserRegistrationRequest>> violations = validator.validate(request);
            if (!violations.isEmpty()){
                throw new ConstraintViolationException(violations);
            }
            User mappedUser = Mapper.map(request);
            User savedUser = userRepository.save(mappedUser);
            UserRegistrationResponse response = Mapper.map(savedUser);
            response.setMessage(USER_REGISTRATION_SUCCESSFUL_MESSAGE);
            mailService.sendRegistrationSuccessfulMail(savedUser.getEmail(), REG_TEMP_PATH, REG_MAIL_SUBJECT);
            return response;
        }catch (Exception exception) {
            throw new RegistrationFailedException(exception.getMessage(), exception);
        }

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

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public EventCreateResponse createEvent(EventCreateRequest request) {
        return eventService.createEvent(request);
    }

    @Override
    public User findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return user;
        }
        throw new UserNotFoundException("User not found");
    }
}

