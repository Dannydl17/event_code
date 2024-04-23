package org.danielsproject.services;

import lombok.SneakyThrows;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.exceptions.EventCreationFailedException;
import org.danielsproject.model.Category;
import org.danielsproject.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.danielsproject.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EventServiceImplTest {

    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void deleteAll(){
        eventService.deleteAll();
    }

    @Test
    @SneakyThrows
    public void createNewEvent_EventIsSuccessfullyCreatedTest() {
        UserRegistrationResponse response = userService.createUser(buildValidUser());
        User user = userService.findUserByEmail(response.getEmail());
        EventCreateRequest request = new EventCreateRequest();
        request.setName("Game");
        request.setAvailableAttendeesCount(50);
        request.setUser(user);
        request.setEventDescription("A football match");
        request.setCategory(Category.GAME);
        userService.createEvent(request);
        EventCreateResponse eventCreateResponse = eventService.createEvent(request);
        assertThat(eventCreateResponse.getMessage()).isEqualTo(EVENT_BOOKING_SUCCESSFUL);
    }


    private UserRegistrationRequest buildValidUser() {
        return UserRegistrationRequest.builder()
                .name("Danny")
                .email("dannyDan@Email.com")
                .password("Dan01@Big_Dawg")
                .build();
    }

    @Test
    @SneakyThrows
    public void createNewEvent_WithNameMoreThan100Characters_EventCreationFailedExceptionIsThrown(){
        UserRegistrationResponse response = userService.createUser(buildValidUser());
        User user = userService.findUserByEmail(response.getEmail());

        assertThatThrownBy(()-> eventService.createEvent(builderWithNameMore(user)), "Throw for Invalidity")
                .isInstanceOf(EventCreationFailedException.class)
                .hasMessageContaining(INVALID_NAME_MESSAGE)
//                .hasMessage("name" + INVALID_NAME_MESSAGE)
                .cause();

    }

    private EventCreateRequest builderWithNameMore(User user) {
        return EventCreateRequest.builder()
                .name("zzzzzddddeerrrddddetyyuujjGameaaaaassdfghjkkkllloooiiuytrewwwwqazxcvbnnzzzzzzzzzzzssssssssssssssuuuty")
                .availableAttendeesCount(50)
                .user(user)
                .eventDescription("A football match")
                .build();
    }

    @Test
    public void createMultipleEventsWithSameName_DuplicateModelExceptionIsThrown(){
    
    }
    
    @Test
    public void createNewEvent_TicketsCanBeReservedForCreatedEvent(){
    
    }
    
    @Test
    public void createNewEvent_TicketsReservationIsLimitedToSpecifiedAmount_ElseExceptionIsThrown(){
    
    }
    



}
