package com.meiit.webalk.ad4ayb;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Getter
@Setter
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private BigDecimal amount;
	private LocalDateTime fromTime;
	private LocalDateTime toTime;
	private boolean active;
	private boolean processed;
	@ManyToOne
	private BookingPerson bookingPerson;
	@ManyToOne
	private Room room;

	public Reservation(){
		super();
	}

	public Reservation(BigDecimal amount, LocalDateTime fromTime, LocalDateTime toTime, boolean active,
			boolean processed, BookingPerson bookingPerson, Room room) {
		super();
		this.amount = amount;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.active = active;
		this.processed = processed;
		this.bookingPerson = bookingPerson;
		this.room = room;
	}
	
}
