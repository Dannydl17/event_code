package org.danielsproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    private LocalDateTime localDateTime;
    private int  availableAttendeesCount;
    @Column(nullable = false, length = 500)
    private String eventDescription;
    @ManyToOne
    private User user;
    @Enumerated
    private Category category;
}
