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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + (processed ? 1231 : 1237);
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (active != other.active)
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency != other.currency)
			return false;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (processed != other.processed)
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reservation [amount=" + amount + ", from=" + from + ", to=" + to + ", active=" + active + ", processed="
				+ processed + ", room=" + room + ", person=" + person + ", currency=" + currency + "]";
	}
	
}
