package org.danielsproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime localDateTime;
    private int  availableAttendeesCount;
    private String eventDescription;
    @ManyToOne
    private User user;
    @Enumerated
    private Category category;
}
