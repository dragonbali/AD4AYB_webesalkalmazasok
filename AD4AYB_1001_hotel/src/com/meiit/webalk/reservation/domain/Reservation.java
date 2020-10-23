package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Reservation {
	private BigDecimal amount;
	private LocalDateTime from;
	private LocalDateTime to;
	private boolean active;
	private boolean processed;
	private Room room;
	private BookingPerson person;
	private Currency currency;
	
	
	
	public Reservation(BigDecimal amount, LocalDateTime from, LocalDateTime to, boolean active, boolean processed,
			Room room, BookingPerson person, Currency currency) {
		super();
		this.amount = amount;
		this.from = from;
		this.to = to;
		this.active = active;
		this.processed = processed;
		this.room = room;
		this.person = person;
		this.currency = currency;
	}
	/*public Reservation() 
	{
		super();
	}
	
	public Reservation(BigDecimal amount, LocalDateTime from, LocalDateTime to, boolean active, boolean processed,
			Currency currency, Room room, BookingPerson person)
	{
		super();
		this.amount = amount;
		this.from = from;
		this.to = to;
		this.active = active;
		this.processed = processed;
		this.currency = currency;
		this.room = room;
		this.person = person;
	}*/
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public BookingPerson getPerson() {
		return person;
	}
	public void setPerson(BookingPerson person) {
		this.person = person;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
