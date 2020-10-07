package com.meiit.webalk.reservation.service;

import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public class ReservationServiceIMPL implements ReservationService {
	private BookingPerson person;
	
	@Override
	public void saveBookingPerson(BookingPerson person) {
		this.person = person;
	}

	@Override
	public BookingPerson findBookingPerson() {
		return person;
	}

	@Override
	public List<Hotel> findAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveReservation(Reservation res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> findAllReservations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkOut() {
		// TODO Auto-generated method stub
		
	}
	
}
