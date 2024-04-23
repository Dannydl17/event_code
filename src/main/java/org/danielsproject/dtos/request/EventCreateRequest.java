package org.danielsproject.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.danielsproject.model.Category;
import org.danielsproject.model.User;

import java.time.LocalDateTime;

import static org.danielsproject.utils.Constants.INVALID_NAME_MESSAGE;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateRequest {
    private Long id;
    @Size(min=2, max=100, message = INVALID_NAME_MESSAGE)
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime localDateTime;
    @Positive
    private int  availableAttendeesCount;
    @Size(min=2, max=100)
    private String eventDescription;
    private User user;
    @Enumerated
    private Category category;
}
