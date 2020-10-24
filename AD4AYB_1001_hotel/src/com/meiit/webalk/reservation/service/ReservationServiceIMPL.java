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
		reservation.setProcessed(true);
		reservations.add(reservation);		
	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservations;
	}

	@Override
	public void checkIn() {
		for (Reservation reservation : reservations) {
			reservation.setFrom(LocalDateTime.now());
			reservation.setActive(true);
		}
	}

	@Override
	public void checkOut() {
		for (Reservation reservation : reservations) {
			reservation.setTo(LocalDateTime.now());
			reservation.setActive(false);
		}
		
	}
	
}
