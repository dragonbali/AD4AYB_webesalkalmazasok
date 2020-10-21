package com.meiit.webalk.reservation.service;

import java.util.List;

import com.meiit.webalk.reservation.domain.*;

public interface ReservationService {
	void saveBookingPerson(BookingPerson person);
	BookingPerson findBookingPerson();
	List<Hotel> findAllHotels();
	void saveReservation(Reservation reservation);
	List<Reservation> findAllReservations();
	void checkIn();
	void checkOut();
	
}
