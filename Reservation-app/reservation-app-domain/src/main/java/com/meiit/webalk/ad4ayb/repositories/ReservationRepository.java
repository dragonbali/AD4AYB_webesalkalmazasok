package com.meiit.webalk.ad4ayb.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository  extends CrudRepository<Reservation, Long> {

    public List<Reservation> findAllByBookingPerson(BookingPerson bookingPerson);

}
