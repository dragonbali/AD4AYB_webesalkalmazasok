package com.meiit.webalk.reservation.view;

import java.util.List;

import com.meiit.webalk.reservation.domain.*;

public interface View {
	BookingPerson readBookingPerson();
	void printWelcomeMessage(BookingPerson person);
	void printBalance(BookingPerson person);
	void printRooms(List<Hotel>hotels);
	Room selectRoom(List<Hotel>hotels);
	void printReservationSaved(Reservation res);
	void printNotEnoughBalance(BookingPerson person);
	void printCheckIn(Reservation res);
	void printCheckOut(Reservation res,BookingPerson person);
	
	
	
	
	
}
