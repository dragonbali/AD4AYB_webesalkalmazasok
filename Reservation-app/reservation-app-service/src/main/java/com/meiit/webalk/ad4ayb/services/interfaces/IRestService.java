package com.meiit.webalk.ad4ayb.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.Room;

public interface IRestService {
	
	public void addHotel(Hotel hotel);
    public void addRoom(Room room);
    public void addBookingPerson(BookingPerson bookingPerson);
    public Optional<BookingPerson> getBookingPersonById(Long id);
    public List<Reservation> getAllReservations();

}
