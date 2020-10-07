package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Floor {
	private int floorNumber;
	private Hotel hotel;
	private List<Wing>wings;
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public List<Wing> getWings() {
		return wings;
	}
	public void setWings(List<Wing> wings) {
		this.wings = wings;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floorNumber;
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((wings == null) ? 0 : wings.hashCode());
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
		Floor other = (Floor) obj;
		if (floorNumber != other.floorNumber)
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (wings == null) {
			if (other.wings != null)
				return false;
		} else if (!wings.equals(other.wings))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Floor [floorNumber=" + floorNumber + ", hotel=" + hotel + ", wings=" + wings + "]";
	}
	
	
}
