package org.danielsproject.services;

import lombok.AllArgsConstructor;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.exceptions.EventNotFoundException;
import org.danielsproject.model.Event;
import org.danielsproject.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    @Override
    public Event createEvent( EventCreateRequest eventCreateRequest ) {
        Event event = new Event();
        event.setName(eventCreateRequest.getName());
        event.setAvailableAttendeesCount(eventCreateRequest.getAvailableAttendeesCount());
        event.setEventDescription(eventCreateRequest.getEventDescription());
        event.setUser(eventCreateRequest.getUser());
        event.setCategory(eventCreateRequest.getCategory());
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> findEvent(Event event) {
        Optional<Event> foundEvent = eventRepository.findById("");
        if (foundEvent.isPresent()) {
            return foundEvent;
        }
        throw new EventNotFoundException("Event not found");
    }
}
