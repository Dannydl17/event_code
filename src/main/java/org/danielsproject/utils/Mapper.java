package org.danielsproject.utils;

import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.model.Category;
import org.danielsproject.model.Event;
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

    public static Event map(EventCreateRequest request) {
        return Event.builder()
                .name(request.getName())
                .localDateTime(request.getLocalDateTime())
                .user(request.getUser())
                .availableAttendeesCount(request.getAvailableAttendeesCount())
                .eventDescription(request.getEventDescription())
                .build();
    }

    public static EventCreateResponse map(Event event) {
        return EventCreateResponse.builder()
                .name(event.getName())
                .availableAttendeesCount(event.getAvailableAttendeesCount())
                .eventDescription(event.getEventDescription())
                .category(Category.GAME)
                .build();

    }
}
