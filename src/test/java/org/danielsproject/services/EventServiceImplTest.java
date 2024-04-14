package org.danielsproject.services;

import lombok.SneakyThrows;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.dtos.response.UserRegistrationResponse;
import org.danielsproject.model.Event;
import org.danielsproject.model.User;
import org.danielsproject.repository.EventRepository;
import org.danielsproject.services.EventService;
import org.danielsproject.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EventServiceImplTest {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private EventRepository eventRepository;
    @BeforeEach
    public void deleteAll(){
        eventRepository.deleteAll();
    }

    @Test
    public void createNewEvent_EventIsSuccessfullyCreatedTest(){
    
    }
    
    @Test
    public void createNewEvent_WithNameMoreThan100Characters_EventCreationFailedExceptionIsThrown(){
    
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
    
    @Test
    @SneakyThrows
    public void testThatEventIsCreatedTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Daniel");
        request.setEmail("danny12@gmail.com");
        request.setPassword("1234");
        UserRegistrationResponse user = userService.createUser(request);
        EventCreateRequest eventCreateRequest = new EventCreateRequest();
        eventCreateRequest.setName("Game");
        eventCreateRequest.setAvailableAttendeesCount(50);
        eventCreateRequest.setEventDescription("A football match");
//        eventCreateRequest.setUser(user);
        eventService.createEvent(eventCreateRequest);
        assertEquals(1, eventRepository.count());
    }


    @Test
    @SneakyThrows
    public void testThatEventCanExistTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Daniel");
        request.setEmail("danny12@gmail.com");
        request.setPassword("1234");
        UserRegistrationResponse user = userService.createUser(request);
        EventCreateRequest eventCreateRequest = new EventCreateRequest();
        eventCreateRequest.setName("Game");
        eventCreateRequest.setAvailableAttendeesCount(50);
        eventCreateRequest.setEventDescription("A football match");
//        eventCreateRequest.setUser(user);
        Event event = eventService.createEvent(eventCreateRequest);
        Optional<Event> eventFound = eventService.findEvent(event);
        assertEquals(eventFound.get().getId(), 1L);
    }
}
