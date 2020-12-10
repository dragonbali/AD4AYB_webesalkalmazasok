package com.meiit.webalk.ad4ayb.services.interfaces;

import com.meiit.webalk.ad4ayb.BookingPerson;

public interface IBookingPersonService {
	
	public BookingPerson findByEmail(String email);
	public void saveBookingPerson(BookingPerson bookingPerson);

}
