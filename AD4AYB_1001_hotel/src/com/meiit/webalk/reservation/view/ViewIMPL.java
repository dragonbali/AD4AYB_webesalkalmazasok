package com.meiit.webalk.reservation.view;

import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

public class ViewIMPL implements View {
	Scanner sc = new Scanner(System.in);
	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("Whats your name?");
		BookingPerson person = new BookingPerson();
		person.setName(sc.next());
		System.out.println("Mennyi a zsé");
		person.setBalance(sc.nextBigDecimal());
		System.out.println("Currency?");
		person.setCurrency(Currency.valueOf(sc.next()));
		System.out.println(person);
		return person;
	}

	@Override
	public void printWelcomeMessage(BookingPerson person) {
		System.out.println("Welcome " + person.getName() );
	}

	@Override
	public void printBalance(BookingPerson person) {
		System.out.println("Your balance is: " + person.getBalance() + person.getCurrency());
	}

	@Override
	public void printRooms(List<Hotel> hotels) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room selectRoom(List<Hotel> hotels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printReservationSaved(Reservation res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printNotEnoughBalance(BookingPerson person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCheckIn(Reservation res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCheckOut(Reservation res, BookingPerson person) {
		// TODO Auto-generated method stub
		
	}
	
}
