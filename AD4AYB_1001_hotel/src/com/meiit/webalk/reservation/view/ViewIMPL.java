package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;

public class ViewIMPL implements View {
	BookingPerson bp = new BookingPerson();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("What's your name?");
		bp.setName(sc.next());
		
		System.out.println("How much money do you have ( more than 0)?");
		bp.setBalance(sc.nextBigDecimal());
		
		System.out.println("What is your currency?(HUF,EUR or USD)");
		bp.setCurrency(Currency.valueOf(sc.next()));
		return bp;
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
		System.out.println("Where do you want to book? (Choose a number or press 0 for quit)");
		//>1: Hotel name: Hilton, Floor: 1, Wing: North, Room number: 1, Beds: 2, Room Price: 500 
		int i = 0;
		for (Hotel hotel : hotels) {
			for (Floor floor : hotel.getFloors()) {
				for (Wing wing : floor.getWings()) {
					for (Room room : wing.getRooms()) {
						i++;
						System.out.print(i + ": Hotel name: " + hotel.getName());
						System.out.print(", Floor: " + floor.getFloorNumber());
						System.out.print(", Wing: " + wing.getWingType());
						System.out.print(", Room number: " + room.getNumber());
						System.out.print(", Beds: " + room.getBeds());
						System.out.println(", Room price: " + room.getPrice());
					}
				}
			}
		}
		
	}

	int input = -1;
	@Override
	public Room selectRoom(List<Hotel> hotels) {
		Room selectedRoom = null;
		int i = 0;	
			input = sc.nextInt();
			if (input == 0) {
				return null;
			}
			for (Hotel hotel : hotels) {
				for (Floor floor : hotel.getFloors()) {
					for (Wing wing : floor.getWings()) {
						for (Room room : wing.getRooms()) {
							i++;
							if (i == input) {
								selectedRoom = room;
							}
						}
					}
				}
			}
		return selectedRoom;
	}

	/*
	  >The reservation succesfuly saved!
	  >Reservation details: Hilton, Floor: 1, Wing: North, Room number: 1, Beds: 2
	  > Your balance is 500 HUF
	 */
	@Override
	public void printReservationSaved(Reservation reservation) {
		System.out.println("The reservation successfully saved!");
		System.out.print("Reservation details: ");
	    System.out.print(reservation.getRoom().getWing().getFloor().getHotel().getName());
		System.out.print(", Floor: " + reservation.getRoom().getWing().getFloor().getFloorNumber());
		System.out.print(", Wing: " + reservation.getRoom().getWing().getWingType());
		System.out.print(", Room: " + reservation.getRoom().getNumber());
		System.out.print(", Room: " + reservation.getRoom().getBeds());		
	}

	@Override
	public void printNotEnoughBalance(BookingPerson reservation) {
		System.out.println("Sorry you dont have enough balance! Please choose anoter room!");
	}

	@Override
	public void printCheckIn(Reservation reservation) {
		System.out.println("Your reservations:");
		System.out.print(reservation.getRoom().getWing().getFloor().getHotel().getName());
		System.out.print(", Floor: " + reservation.getRoom().getWing().getFloor().getFloorNumber());
		System.out.print(", Wing: " + reservation.getRoom().getWing().getWingType());
		System.out.print(", Room: " + reservation.getRoom().getNumber());
		System.out.println(", Room: " + reservation.getRoom().getBeds());	
		System.out.println("Check in");
	}

	@Override
	public void printCheckOut(Reservation reservation, BookingPerson person) {
		System.out.println("Few days later");
		System.out.println("Check out, Suprise! You are the 100th guest you get a 10% refund");
		Double refund = 0.0;
	
		refund = reservation.getAmount().doubleValue() * 0.1;
		person.setBalance(person.getBalance().add(BigDecimal.valueOf(refund)));
		System.out.println("Your new balance is " + person.getBalance() + person.getCurrency() + " (balance after refund)");
	}
	
}
