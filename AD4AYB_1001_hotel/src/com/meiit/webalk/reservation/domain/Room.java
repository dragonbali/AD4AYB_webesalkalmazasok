package com.meiit.webalk.reservation.domain;

import java.math.BigDecimal;

public class Room {
	private int number;
	private int beds;
	private boolean balcony;
	private BigDecimal price;
	private Wing wing;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public boolean isBalcony() {
		return balcony;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Wing getWing() {
		return wing;
	}
	public void setWing(Wing wing) {
		this.wing = wing;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (balcony ? 1231 : 1237);
		result = prime * result + beds;
		result = prime * result + number;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((wing == null) ? 0 : wing.hashCode());
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
		Room other = (Room) obj;
		if (balcony != other.balcony)
			return false;
		if (beds != other.beds)
			return false;
		if (number != other.number)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (wing == null) {
			if (other.wing != null)
				return false;
		} else if (!wing.equals(other.wing))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Room [number=" + number + ", beds=" + beds + ", balcony=" + balcony + ", price=" + price + ", wing="
				+ wing + "]";
	}
	
}
