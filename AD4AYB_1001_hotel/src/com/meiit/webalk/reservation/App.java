package com.meiit.webalk.reservation;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.service.ReservationServiceIMPL;
import com.meiit.webalk.reservation.view.View;
import com.meiit.webalk.reservation.view.ViewIMPL;

public class App {
	private ReservationService service;
	private View view;
	
	
	public static void main(String[] args) {
		ReservationService service = new ReservationServiceIMPL();
		View view = new ViewIMPL();
		App app = new App(service, view);
		app.book();
	}
	
	public App(ReservationService service,View view) {
		this.service = service;
		this.view = view;
	}
	
	public void createBookingPerson() {
		BookingPerson person = view.readBookingPerson();
		service.saveBookingPerson(person);
	}
	
	public void book() {
		createBookingPerson();
		BookingPerson person = service.findBookingPerson();
		view.printWelcomeMessage(person);
		view.printBalance(person);
	}
	
	public void checkIn() {
		
	}
	
	public void checkOut() {
		
	}
}
