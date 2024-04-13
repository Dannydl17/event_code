package org.danielsproject.services;

import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.model.Event;

import java.util.Optional;

public interface EventService {
    Event createEvent( EventCreateRequest eventCreateRequest );

    Optional<Event> findEvent(Event event);

}
