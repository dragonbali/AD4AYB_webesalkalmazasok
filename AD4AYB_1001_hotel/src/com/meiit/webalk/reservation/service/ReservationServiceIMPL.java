package com.meiit.webalk.reservation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.HotelData;
import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

public class ReservationServiceIMPL implements ReservationService {
	private BookingPerson person;
	List<Reservation> reservations = new ArrayList<Reservation>();
	
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
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(HotelData.SomeData());
		return hotels;
	}

	@Override
	public void saveReservation(Reservation reservation) {
		reservations.add(reservation);
		
	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservations;
	}

	@Override
	public void checkIn() {
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setFrom(LocalDateTime.now());
			reservations.get(i).setActive(true);		
		}
		
	}

	@Override
	public void checkOut() {
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setTo(LocalDateTime.now());
			reservations.get(i).setActive(false);		
		}
		
	}
	
}
