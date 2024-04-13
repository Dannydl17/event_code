package org.danielsproject.services;

import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.request.UserRegistrationRequest;
import org.danielsproject.model.Event;
import org.danielsproject.model.User;
import org.danielsproject.repository.EventRepository;
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
    public void testThatEventIsCreatedTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Daniel");
        request.setEmail("danny12@gmail.com");
        request.setPassword("1234");
        User user = userService.createUser(request);
        EventCreateRequest eventCreateRequest = new EventCreateRequest();
        eventCreateRequest.setName("Game");
        eventCreateRequest.setAvailableAttendeesCount(50);
        eventCreateRequest.setEventDescription("A football match");
        eventCreateRequest.setUser(user);
        eventService.createEvent(eventCreateRequest);
        assertEquals(1, eventRepository.count());
    }


    @Test
    public void testThatEventCanExistTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("Daniel");
        request.setEmail("danny12@gmail.com");
        request.setPassword("1234");
        User user = userService.createUser(request);
        EventCreateRequest eventCreateRequest = new EventCreateRequest();
        eventCreateRequest.setName("Game");
        eventCreateRequest.setAvailableAttendeesCount(50);
        eventCreateRequest.setEventDescription("A football match");
        eventCreateRequest.setUser(user);
        Event event = eventService.createEvent(eventCreateRequest);
        Optional<Event> eventFound = eventService.findEvent(event);
        assertEquals(eventFound.get().getId(), 1L);
    }
}
