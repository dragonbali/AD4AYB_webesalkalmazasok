package com.meiit.webalk.ad4ayb.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.services.RestService;

@RestController
public class RestEndController {
	
	RestService restService;

	@Autowired
	public void setRestService(RestService restService) {
		this.restService = restService;
	}

	@PostMapping("/add-hotel")
	public void addHotel(Hotel hotel) {
		restService.addHotel(hotel);
	}
	
	@PostMapping("/add-room")
	public void addRoom(Room room) {
		restService.addRoom(room);
	}
	
	@PostMapping("/create-user")
    public void createUser(BookingPerson bookingPerson){
		restService.addBookingPerson(bookingPerson);
	}
	
	@PostMapping("/user-info")
    public Optional<BookingPerson> userInfo(Long id){
		return restService.getBookingPersonById(id);
	}
	@PostMapping("/show-reserveations")
	public List<Reservation> showReservations() {
		return restService.getAllReservations();
	}
}
