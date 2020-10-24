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
	BookingPerson bookingPerson = new BookingPerson();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public BookingPerson readBookingPerson() {
		String input2 = "";
		
		System.out.println("What's your name?");
		input2 = sc.next();
		bookingPerson.setName(input2);
		
		do {
			System.out.println("How much money do you have (more than 0)?");
			input2 = sc.next();
		} while (!InputCheck.balanceCheck(input2));	
		BigDecimal bigDecimalInput = new BigDecimal(input2);
		bookingPerson.setBalance(bigDecimalInput);
		
		do  {			
			System.out.println("What is your currency?(HUF,EUR or USD)");
			input2 = sc.next();
		} while (!InputCheck.currencyCheck(input2));	
		bookingPerson.setCurrency(Currency.valueOf(input2));
		
		return bookingPerson;
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
		System.out.println("Where do you want to book? (Choose a number or press q for quit)");
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

	String input = "";
	@Override
	public Room selectRoom(List <Hotel> hotels) {
	    Room selectedRoom = null;
	    int i = 0;
	    input = sc.next();
	    if (!InputCheck.isQCheck(input)) {
	        return null;
	    } else {
	        if ((!InputCheck.moreThanZeroAndIsNumer(input)) || (!InputCheck.enoughRoomCheck(input, hotels))) {
	            do {
	                printRooms(hotels);
	                input = sc.next();
	            } while ((!InputCheck.enoughRoomCheck(input, hotels)) && (!InputCheck.moreThanZeroAndIsNumer(input)));
	        }
	        for (Hotel hotel: hotels) {
	            for (Floor floor: hotel.getFloors()) {
	                for (Wing wing: floor.getWings()) {
	                    for (Room room: wing.getRooms()) {
	                        i++;
	                        if (i == Integer.parseInt(input)) {
	                            selectedRoom = room;
	                        }
	                    }
	                }
	            }
	        }
	        return selectedRoom;
	    }
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
		System.out.print(", Floor: " + reservation.getRoom().getNumber());
		System.out.print(", Room: " + reservation.getRoom().getBeds());		
	}

	@Override
	public void printNotEnoughBalance(BookingPerson reservation) {
		System.out.println("Sorry you dont have enough balance! Please choose anoter room!");
	}

	@Override
	public void printCheckIn(Reservation reservation) {
		System.out.println("Your reservations:(only the first)");
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
		System.out.println("Your new balance is " + person.getBalance() + person.getCurrency() + " (balance after refund)(only by the first)");
	}
	
}
