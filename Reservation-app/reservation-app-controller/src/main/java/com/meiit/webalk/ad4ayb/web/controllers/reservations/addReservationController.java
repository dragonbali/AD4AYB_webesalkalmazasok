package com.meiit.webalk.ad4ayb.web.controllers.reservations;


import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.Wing;
import com.meiit.webalk.ad4ayb.services.BookingPersonService;
import com.meiit.webalk.ad4ayb.services.HotelService;
import com.meiit.webalk.ad4ayb.services.ReservationService;

@Controller
public class addReservationController {
	
	HotelService hotelService;
	BookingPersonService bookingPersonService;
	ReservationService reservationService;
		
	@Autowired	
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@Autowired
	public void setBookingPersonService(BookingPersonService bookingPersonService) {
		this.bookingPersonService = bookingPersonService;
	}

	@Autowired
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	Hotel saveHotel;
	Floor saveFloor;
	Wing saveWing;
	Room saveRoom;
	
	@PostMapping("/chosenHotel")
	public String chosenHotel (@ModelAttribute Hotel hotel, Model model) {
		saveHotel = hotel;
		return "redirect:/floors";
	}
	
	@GetMapping("/floors")
	public String getFloors(Model model) {
		model.addAttribute("floors", hotelService.getFloorsOfAHotel(saveHotel));
		model.addAttribute("hotel", saveHotel);
		return "floors";
	}
	
	@PostMapping("/chosenFloor")
	public String chosenFloor (@ModelAttribute Floor floor, Model model) {
		saveFloor = floor;
		return "redirect:/wings";
	}
	
	@GetMapping("/wings")
	public String getWings(Model model) {
		model.addAttribute("wings", hotelService.getWingsOfAFloor(saveFloor));
		model.addAttribute("hotel", saveHotel);
		return "wings";
	}
	
	@PostMapping("/chosenWing")
	public String chosenWing (@ModelAttribute Wing wing, Model model) {
		saveWing= wing;
		return "redirect:/rooms";
	}
	
	@GetMapping("/rooms")
	public String getRooms(Model model) {
		model.addAttribute("rooms", hotelService.getRoomsOfAWing(saveWing));
		model.addAttribute("wing", saveWing);
		model.addAttribute("floor", saveFloor);
		model.addAttribute("hotel", saveHotel);
		return "rooms";
	}
	
	@PostMapping("/chosenRoom")
	public String chosenRoom(@ModelAttribute Room room, Model model, Principal principal) {
		saveRoom = room;	
		Reservation saveReservation = new Reservation(saveRoom.getPrice(), LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(3), false, false, bookingPersonService.getBookingPersonByEmail(principal.getName()), saveRoom); 
		reservationService.addReservation(saveReservation);
		return "redirect:/userInfo";
	}
	
}
