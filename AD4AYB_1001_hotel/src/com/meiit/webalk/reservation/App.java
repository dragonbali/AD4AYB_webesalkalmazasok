package com.meiit.webalk.reservation;

import java.time.LocalDateTime;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
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
		app.createBookingPerson();
		app.book();
	//	app.checkIn();
	//	app.checkOut();
	}
	
	public App(ReservationService service,View view) {
		this.service = service;
		this.view = view;
	}
	
	public void createBookingPerson() {
		BookingPerson person = view.readBookingPerson();
		service.saveBookingPerson(person);
		view.printWelcomeMessage(person);
		view.printBalance(person);
	}
	
public void book() {
	Room selectedRoom = null;
	BookingPerson person = service.findBookingPerson();
		do {
			view.printRooms(service.findAllHotels());
			selectedRoom = view.selectRoom(service.findAllHotels());
			if (person.getBalance().compareTo(selectedRoom.getPrice()) >= 0) {
				Reservation reservation = new Reservation(selectedRoom.getPrice(), 
														  LocalDateTime.now(), 
														  LocalDateTime.now().plusDays(1),
														  true,
														  true,													  
														  selectedRoom,
														  person,
														  person.getCurrency());
				
				service.saveReservation(reservation);
				view.printReservationSaved(reservation);
				person.setBalance(person.getBalance().subtract(selectedRoom.getPrice()));
				
			}else {
				view.printNotEnoughBalance(person);
				selectedRoom = null;
			}
			
			view.printBalance(person);
			
		}while(selectedRoom == null);
	}
	
	public void checkIn() {
		Reservation reservation = service.findAllReservations().get(service.findAllHotels().size());
		view.printCheckIn(reservation);
		
	}
	
	public void checkOut() {
		Reservation reservation = service.findAllReservations().get(service.findAllHotels().size());
		BookingPerson person = view.readBookingPerson();
		view.printCheckOut(reservation, person);
	}
}
