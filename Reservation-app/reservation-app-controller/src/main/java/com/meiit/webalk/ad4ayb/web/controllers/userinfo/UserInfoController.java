package com.meiit.webalk.ad4ayb.web.controllers.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.services.BookingPersonService;
import com.meiit.webalk.ad4ayb.services.ReservationService;

@Controller
public class UserInfoController {
	
	BookingPersonService bookingPersonService;
	ReservationService reservationService;

	@Autowired
	public void setBookingPersonService(BookingPersonService bookingPersonService) {
		this.bookingPersonService = bookingPersonService;
	}
	
	@Autowired
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
			//az email a secuitybol jon majd valojaban
			String testuseremail = "balu@balu.hu";
		model.addAttribute("bookingPerson",bookingPersonService.getBookingPersonByEmail(testuseremail));
		model.addAttribute("reservations", reservationService.getReservationsByEmail(testuseremail));	
		return "userInfo";
	}

	@GetMapping("/userInfo")
	public String getUserInfo(Model model) {
			//az email a secuitybol jon majd valojaban
			String testuseremail = "balu@balu.hu";
		model.addAttribute("bookingPerson",bookingPersonService.getBookingPersonByEmail(testuseremail));
		model.addAttribute("reservations", reservationService.getReservationsByEmail(testuseremail));	
		return "userInfo";
	}
	
	@PostMapping("/userInfoModify")
	public String UserInfoModify(@ModelAttribute("bookingPerson") BookingPerson bookingPerson) {
		bookingPersonService.addBookingPerson(bookingPerson);
		return "redirect:/userInfo";
	}

}
