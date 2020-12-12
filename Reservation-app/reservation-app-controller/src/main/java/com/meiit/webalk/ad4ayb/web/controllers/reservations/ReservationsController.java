package com.meiit.webalk.ad4ayb.web.controllers.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.services.ReservationService;

@Controller
public class ReservationsController {

	ReservationService reservationService;

	@Autowired
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PostMapping("/deleteReservation")
	public String deleteReservation(@ModelAttribute("reservation") Reservation reservation){
		reservationService.deleteReservation(reservation);
        return "redirect:/userInfo";
    }
}
