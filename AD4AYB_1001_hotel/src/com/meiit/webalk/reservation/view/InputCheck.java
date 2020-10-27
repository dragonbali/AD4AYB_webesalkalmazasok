package com.meiit.webalk.reservation.view;

import java.util.List;

import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;

public class InputCheck {
	
	//Very NICE

	static boolean currencyCheck(String input) {
		boolean isOK = false;
		if (input.equals("HUF")) {
			isOK = true;
		} else if (input.equals("EUR")) {
			isOK = true;
		} else if (input.equals("USD")) {
			isOK = true;
		} else {
			System.out.println("Wrong input!");
			isOK = false;
		}
		return isOK;
	}
	
	static boolean balanceCheck(String input) {
		try {
			Integer.parseInt(input);
			if (Integer.parseInt(input) > 0) {
				return true;
			}else {
				System.out.println("Wrong input!");
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Wrong input!");
			return false;
		}		
	}
	
	static boolean isQCheck(String input) {	
	    if (input.equals("q")) {
	        return false;
	    } else {
	    	return true;
	        }
	    }
	
	static boolean moreThanZeroAndIsNumer(String input) {
		boolean isNumber = false;
		boolean moreThanZero = false;
		try {
			Integer.parseInt(input);
			isNumber = true;

		} catch (NumberFormatException e) {
			System.out.println("Your input is not a number or q for QUIT! Try Again!");
			return false;
		}
		
		if (Integer.parseInt(input) > 0) {
			moreThanZero = true;
		}
		if (moreThanZero && isNumber) {
			return true;
		}else {
			return false;
		}
	}	
	
	@SuppressWarnings("unused")
	static boolean enoughRoomCheck(String input, List <Hotel> hotels) {
	    int i = 0;
	    for (Hotel hotel: hotels) {
	        for (Floor floor: hotel.getFloors()) {
	            for (Wing wing: floor.getWings()) {
	                for (Room room: wing.getRooms()) {
	                    i++;
	                }
	            }
	        }
	    }
	    if (i < Integer.parseInt(input)) {
	        System.out.println("Wrong input! There is only " + i + " rooms.");
	        return false;
	    } else {
	        return true;
	    }
	}
	
}
