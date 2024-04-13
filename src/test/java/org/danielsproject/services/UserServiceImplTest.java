package org.danielsproject.services;

import org.danielsproject.dtos.request.UserLoginRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.model.User;
import org.danielsproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testThatCanCreateUserTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Danny");
        request.setEmail("dannyDan12@gmail.com");
        request.setPassword("1234");
        userService.createUser(request);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void testThatCantCreateUserTwice(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Danny");
        request.setEmail("dannyDan12@gmail.com");
        request.setPassword("1234");
        userService.createUser(request);


        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail("dannyDan12@gmail.com");
        userLoginRequest.setPassword("1234");
        userService.login(userLoginRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatUserExistTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Danny");
        request.setEmail("dannyDan10@gmail.com");
        request.setPassword("1234");
        User user = userService.createUser(request);

        Optional<User> userExist = userService.findUser(user);
        assertEquals(userExist.get().getEmail(),"dannyDan10@gmail.com");
    }

}