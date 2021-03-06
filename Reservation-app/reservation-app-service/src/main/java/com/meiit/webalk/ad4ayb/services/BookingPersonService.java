package com.meiit.webalk.ad4ayb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.repositories.BookingPersonRepository;
import com.meiit.webalk.ad4ayb.services.interfaces.IBookingPersonService;

@Service
public class BookingPersonService implements IBookingPersonService {
	
	 
	 BookingPersonRepository bookingPersonRepository;
	 
	 @Autowired
	 public void setBookingPersonRepository(BookingPersonRepository bookingPersonRepository) {
		this.bookingPersonRepository = bookingPersonRepository;
	}

		@Override
	    public BookingPerson getBookingPersonByEmail(String email) {
	        BookingPerson bookingPerson = bookingPersonRepository.findByEmail(email);
	        return bookingPerson;
	    }
	    
	    @Override
	    public void addBookingPerson(BookingPerson bookingPerson) {
	        bookingPersonRepository.save(bookingPerson);
	    }

}
