package org.danielsproject.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.danielsproject.model.Category;
import org.danielsproject.model.User;

import java.time.LocalDateTime;

@Setter
@Getter
public class EventCreateRequest {
    private Long id;
    private String name;
    private LocalDateTime localDateTime;
    private int  availableAttendeesCount;
    private String eventDescription;
    private User user;
    private Category category;
}
