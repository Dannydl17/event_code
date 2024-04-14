package org.danielsproject.utils;

import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.model.User;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Mapper {


    public static User map(UserRegistrationRequest request) {
        return User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .password(request.getPassword())
                .build();
    }

    public static UserRegistrationResponse map(User user) {
        return UserRegistrationResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
