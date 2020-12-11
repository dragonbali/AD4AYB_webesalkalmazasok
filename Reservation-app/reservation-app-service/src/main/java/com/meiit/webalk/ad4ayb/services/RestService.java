package com.meiit.webalk.ad4ayb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.repositories.BookingPersonRepository;
import com.meiit.webalk.ad4ayb.repositories.HotelRepository;
import com.meiit.webalk.ad4ayb.repositories.ReservationRepository;
import com.meiit.webalk.ad4ayb.repositories.RoomRepository;
import com.meiit.webalk.ad4ayb.repositories.UserRepository;
import com.meiit.webalk.ad4ayb.services.interfaces.IRestService;

@Service
public class RestService implements IRestService {

    HotelRepository hotelRepository;
    RoomRepository roomRepository;
    BookingPersonRepository bookingPersonRepository;
    ReservationRepository reservationRepository;
    UserRepository userRepository;

    @Autowired
	public void setHotelRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

    @Autowired
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

    @Autowired
	public void setBookingPersonRepository(BookingPersonRepository bookingPersonRepository) {
		this.bookingPersonRepository = bookingPersonRepository;
	}

    @Autowired
	public void setReservationRepository(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

    @Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void addHotel(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public void addRoom(Room room) {
		roomRepository.save(room);
		
	}

	@Override
	public void addBookingPerson(BookingPerson bookingPerson) {
		bookingPersonRepository.save(bookingPerson);		
	}

	@Override
	public Optional<BookingPerson> getBookingPersonById(Long id) {	
		return bookingPersonRepository.findById(id);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return (List<Reservation>) reservationRepository.findAll();
	}
	
}
