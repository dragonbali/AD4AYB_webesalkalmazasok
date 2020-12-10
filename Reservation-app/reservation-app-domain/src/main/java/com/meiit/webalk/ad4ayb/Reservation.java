package com.meiit.webalk.ad4ayb;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private BigDecimal amount;
	private LocalDateTime from;
	private LocalDateTime to;
	private boolean active;
	private boolean processed;
	@ManyToOne
	private Room room;
	@ManyToOne
	private BookingPerson person;
}
