package org.danielsproject.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.exceptions.EventCreationFailedException;
import org.danielsproject.exceptions.EventNotFoundException;
import org.danielsproject.model.Event;
import org.danielsproject.repository.EventRepository;
import org.danielsproject.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static org.danielsproject.utils.Constants.EVENT_BOOKING_SUCCESSFUL;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private Validator validator;
    @Override
    public EventCreateResponse createEvent(EventCreateRequest eventCreateRequest) throws EventCreationFailedException {
        try{
            Set<ConstraintViolation<EventCreateRequest>> violations = validator.validate(eventCreateRequest);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            Event mapperEvent = Mapper.map(eventCreateRequest);
            Event event = eventRepository.save(mapperEvent);
            EventCreateResponse response = Mapper.map(event);
            response.setMessage(EVENT_BOOKING_SUCCESSFUL);
            return response;
        }catch (Exception e){
            throw new EventCreationFailedException(e.getMessage(), e);
        }

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
