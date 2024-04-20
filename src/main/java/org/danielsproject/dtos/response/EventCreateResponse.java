package org.danielsproject.dtos.response;

import lombok.*;
import org.danielsproject.model.Category;
import org.danielsproject.model.User;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateResponse {
    private String name;
    private LocalDateTime localDateTime;
    private int  availableAttendeesCount;
    private String eventDescription;
    private Category category;
    private String message;
}
