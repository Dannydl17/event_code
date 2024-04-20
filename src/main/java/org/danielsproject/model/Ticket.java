package org.danielsproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = UUID)
	private String id;
	@OneToOne
	private User user;
	@ManyToOne
	private Event event;
	private LocalDateTime timeReserved;
}
