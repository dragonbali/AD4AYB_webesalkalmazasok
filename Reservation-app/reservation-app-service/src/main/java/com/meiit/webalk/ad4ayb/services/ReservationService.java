package com.meiit.webalk.ad4ayb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.repositories.BookingPersonRepository;
import com.meiit.webalk.ad4ayb.repositories.ReservationRepository;
import com.meiit.webalk.ad4ayb.services.interfaces.IReservationService;

@Service
public class ReservationService implements IReservationService {
	
    BookingPersonRepository bookingPersonRepository;
    ReservationRepository reservationRepository;
	
	@Autowired
	public void setBookingPersonRepository(BookingPersonRepository bookingPersonRepository) {
		this.bookingPersonRepository = bookingPersonRepository;
	}

	@Autowired
	public void setReservationRepository(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	@Override
    public List<Reservation> getReservationsByEmail(String email) {
        BookingPerson bookingPerson = bookingPersonRepository.findByEmail(email);
        List<Reservation> reservations = reservationRepository.findAllByBookingPerson(bookingPerson);
        
        if((reservations == null) || (reservations.size() == 0)){
            return null;
        }
        return reservations;
    }
	
	@Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
	
	@Override
    public void deleteReservation(Reservation reservation) {
        reservationRepository.delete(reservation);
    }
	
}
