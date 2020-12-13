package com.meiit.webalk.ad4ayb.web.controllers.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.meiit.webalk.ad4ayb.services.HotelService;

@Controller
public class HotelsController {

	HotelService hotelService;

	@Autowired
	public void setHotelService(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@GetMapping("/hotels")
	public String showHotels(Model model) {
		model.addAttribute("hotels", hotelService.getAllHotels());
		return "hotels";
	}
}
