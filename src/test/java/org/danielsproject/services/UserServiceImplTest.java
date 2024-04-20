package org.danielsproject.services;

import lombok.SneakyThrows;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.exceptions.RegistrationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.danielsproject.utils.Constants.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @BeforeEach
    public void startEachTestWith(){
        userService.deleteAll();
    }
    @Test
    public void testThatUsersTryToRegisterWithIncompleteDetails_RegistrationFailedExceptionIsThrown(){
        assertThatThrownBy(()-> userService.createUser(buildUserWithIncompleteDetails()), "Throw For Invalidity")
                .isInstanceOf(RegistrationFailedException.class)
                .hasMessageContaining(BLANK_FIELD_MESSAGE)
                .hasMessage("password: " + BLANK_FIELD_MESSAGE)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUsersTryToRegisterWithInvalidEmailFormat_RegistrationFailedExceptionIsThrown(){
        assertThatThrownBy(()->userService.createUser(buildUserWithInvalidEmail()), "Throw For Invalidity")
                .isInstanceOf(RegistrationFailedException.class)
                .hasMessageContaining(INVALID_EMAIL_MESSAGE)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUsersTryToRegisterWithInvalidPasswordFormat_RegistrationFailedExceptionIsThrown(){
        assertThatThrownBy(()->userService.createUser(buildUserWithInvalidPassword()))
                .hasMessageContaining(INVALID_PASSWORD_MESSAGE)
                .isInstanceOf(RegistrationFailedException.class)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUsersTryToRegisterMoreThanOnce_DuplicateModelExceptionIsThrown(){
        userService.createUser(buildValidUser());
        assertThatThrownBy(()->userService.createUser(buildValidUser()), "Duplicate User Test")
                .isInstanceOf(Exception.class)
                .isExactlyInstanceOf(RegistrationFailedException.class)
                .hasMessageContaining(DUPLICATE_USER_MESSAGE)
                .cause();
    }

    @Test
    @SneakyThrows
    public void testThatUsersCanRegisterSuccessfully_IfAllChecksArePassed(){
        UserRegistrationResponse response = userService.createUser(buildValidUser());
        assertThat(userService.existsByEmail(response.getEmail())).isTrue();
        assertThat(response.getMessage()).isNotNull();
        assertThat(response.getMessage()).isEqualTo(USER_REGISTRATION_SUCCESSFUL_MESSAGE);
    }
    


    private UserRegistrationRequest buildUserWithIncompleteDetails() {
        return UserRegistrationRequest.builder()
                .email("alaabdulmalik03@gmail.com")
                .name("Danny_Big_Dawg")
                .build();
    }

    private UserRegistrationRequest buildUserWithInvalidEmail() {
        return UserRegistrationRequest.builder()
                .password("Hello World")
                .email("email#domain.com")
                .name("Danny_Big_Dawg")
                .build();
    }

    private UserRegistrationRequest buildUserWithInvalidPassword() {
        return UserRegistrationRequest.builder()
                .name("Danny_Big_Dawg")
                .email("email@gmail.com")
                .password("Hello World")
                .build();
    }


    private UserRegistrationRequest buildValidUser() {
        return UserRegistrationRequest.builder()
                .password("Dan01@Big_Dawg")
                .email("email@native.semicolon.africa")
                .name("Danny_Big_Dawg")
                .build();
    }
}
/*
    @Test
    @SneakyThrows
    public void testThatCanCreateUserTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Danny");
        request.setEmail("dannyDan12@gmail.com");
        request.setPassword("1234");
        userService.createUser(request);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void testThatCantCreateUserTwice() throws RegistrationFailedException {
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
//        UserRegistrationResponse user = userService.createUser(request);

        Optional<User> userExist = userService.findUser(new User());
        assertEquals(userExist.get().getEmail(),"dannyDan10@gmail.com");
    }
    */