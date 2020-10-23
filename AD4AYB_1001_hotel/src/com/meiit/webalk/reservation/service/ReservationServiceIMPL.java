package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;

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
		hotels.add(data());
		return hotels;
	}

	@Override
	public void saveReservation(Reservation reservation) {
		reservations.add(reservation);
		
	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservations;
	}

	@Override
	public void checkIn() {
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setFrom(LocalDateTime.now());
			reservations.get(i).setActive(true);		
		}
		
	}

	@Override
	public void checkOut() {
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setTo(LocalDateTime.now());
			reservations.get(i).setActive(false);		
		}
		
	}
	
	static Hotel data() {
		Hotel hotel = new Hotel();
		hotel.setAddress("király út");
		hotel.setName("Marriott");
		hotel.setStars(5);

		List<Floor> floors = new ArrayList<Floor>();
		Floor flooroom1 = new Floor();
		flooroom1.setFloorNumber(1);
		flooroom1.setHotel(hotel);

		List<Wing> wings = new ArrayList<Wing>();
		Wing wing1 = new Wing();
		wing1.setDescription("North");
		wing1.setFloor(flooroom1);

		List<Room> rooms = new ArrayList<Room>();
		Room room1 = new Room();
		room1.setBalcon(true);
		room1.setBeds(2);
		room1.setNumber(1);
		room1.setPrice(BigDecimal.valueOf(400));
		room1.setWingType(WingType.NORTH);
		rooms.add(room1);

		Room room2 = new Room();
		room2.setBalcon(true);
		room2.setBeds(4);
		room2.setNumber(2);
		room2.setPrice(BigDecimal.valueOf(1400));
		room2.setWingType(WingType.NORTH);
		rooms.add(room2);

		Room room3 = new Room();
		room3.setBalcon(true);
		room3.setBeds(1);
		room3.setNumber(3);
		room3.setPrice(BigDecimal.valueOf(100));
		room3.setWingType(WingType.NORTH);
		rooms.add(room3);

		Room room4 = new Room();
		room4.setBalcon(false);
		room4.setBeds(2);
		room4.setNumber(4);
		room4.setPrice(BigDecimal.valueOf(400));
		room4.setWingType(WingType.NORTH);
		rooms.add(room4);

		wing1.setRooms(rooms);
		wings.add(wing1);

		flooroom1.setWings(wings);
		floors.add(flooroom1);

		hotel.setFloors(floors);
		return hotel;
	}
	
}
