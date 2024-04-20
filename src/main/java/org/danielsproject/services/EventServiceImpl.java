package org.danielsproject.services;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.exceptions.EventNotFoundException;
import org.danielsproject.model.Event;
import org.danielsproject.repository.EventRepository;
import org.danielsproject.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.danielsproject.utils.Constants.EVENT_BOOKING_SUCCESSFUL;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;

    @Override
    public EventCreateResponse createEvent(EventCreateRequest eventCreateRequest) {
        Event mapperEvent = Mapper.map(eventCreateRequest);
        Event event = eventRepository.save(mapperEvent);
        EventCreateResponse response = Mapper.map(event);
        response.setMessage(EVENT_BOOKING_SUCCESSFUL);
        return response;
    }

    @Override
    public Optional<Event> findEvent(Event event) {
        Optional<Event> foundEvent = eventRepository.findById("");
        if (foundEvent.isPresent()) {
            return foundEvent;
        }
        throw new EventNotFoundException("Event not found");
    }

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }


}
