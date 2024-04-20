package org.danielsproject.services;

import org.danielsproject.dtos.request.EventCreateRequest;
import org.danielsproject.dtos.response.EventCreateResponse;
import org.danielsproject.model.Event;

import java.util.Optional;

public interface EventService {
    EventCreateResponse createEvent(EventCreateRequest request);

    Optional<Event> findEvent(Event event);

    void deleteAll();
}
