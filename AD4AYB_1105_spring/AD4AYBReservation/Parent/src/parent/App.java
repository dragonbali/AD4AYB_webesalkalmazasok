package com.meiit.webalk.reservation;


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
		app.checkIn();
		app.checkOut();
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
		boolean done = false;
		boolean wasASave = false;
			do {
				view.printRooms(service.findAllHotels());
				selectedRoom = view.selectRoom(service.findAllHotels());
				if ((selectedRoom == null) && wasASave == true) {
					break;
				}
				if ((selectedRoom == null) && wasASave == false) {
					System.out.println("You quit, but didn't chose any room. Program closed!");
					System.exit(0);
				}else {
					Reservation reservation = new Reservation();

					reservation.setAmount(selectedRoom.getPrice());
					reservation.setRoom(selectedRoom);
					reservation.setPerson(person);
					reservation.setCurrency(person.getCurrency());
					
					service.saveReservation(reservation);
					
					if (person.getBalance().compareTo(selectedRoom.getPrice()) >= 0) {	
						view.printReservationSaved(reservation);
						person.setBalance(person.getBalance().subtract(selectedRoom.getPrice()));
						wasASave = true;						
					}else {
						view.printNotEnoughBalance(person);
						selectedRoom = null;
					}				
				view.printBalance(person);
				}
			}while(!done);
		}
	
	//check in only to the first reservation
	public void checkIn() {
		BookingPerson person = service.findBookingPerson();
		Reservation reservationAcutal = null;
		for (Reservation reservation : service.findAllReservations()) {
			if (reservation.getPerson() == person) {
				reservationAcutal = reservation;
				break;
			}
		}
		service.checkIn();
		view.printCheckIn(reservationAcutal);	
	}
	
	//refund only for the first reservation
	public void checkOut() {
		BookingPerson person = service.findBookingPerson();
		Reservation reservationAcutal = null;
		for (Reservation reservation : service.findAllReservations()) {
			if (reservation.getPerson() == person) {
				reservationAcutal = reservation;
				break;
			}
		}
		service.checkOut();		
		view.printCheckOut(reservationAcutal, service.findBookingPerson());
	}
}
