package com.meiit.webalk.ad4ayb.services.interfaces;

import com.meiit.webalk.ad4ayb.BookingPerson;

public interface IBookingPersonService {
	
	public BookingPerson getBookingPersonByEmail(String email);
	public void addBookingPerson(BookingPerson bookingPerson);

}
