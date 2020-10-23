package com.meiit.webalk.reservation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;

public class HotelData {

	public static Hotel SomeData() {
		Hotel hotel = new Hotel();
		hotel.setAddress("király út");
		hotel.setName("Marriott");
		hotel.setStars(5);

		List<Floor> floors = new ArrayList<Floor>();
		Floor floor1 = new Floor();
		floor1.setFloorNumber(1);
		floor1.setHotel(hotel);

		List<Wing> wings = new ArrayList<Wing>();
		Wing wing1 = new Wing();
		wing1.setDescription("North");
		wing1.setFloor(floor1);
		wing1.setWingType(WingType.NORTH);

		List<Room> rooms = new ArrayList<Room>();
		Room room1 = new Room();
		room1.setBalcon(true);
		room1.setBeds(2);
		room1.setNumber(1);
		room1.setPrice(BigDecimal.valueOf(400));
		room1.setWing(wing1);
		rooms.add(room1);

		Room room2 = new Room();
		room2.setBalcon(true);
		room2.setBeds(4);
		room2.setNumber(2);
		room2.setPrice(BigDecimal.valueOf(1400));
		room2.setWing(wing1);
		rooms.add(room2);

		Room room3 = new Room();
		room3.setBalcon(true);
		room3.setBeds(1);
		room3.setNumber(3);
		room3.setPrice(BigDecimal.valueOf(100));
		room3.setWing(wing1);
		rooms.add(room3);

		Room room4 = new Room();
		room4.setBalcon(false);
		room4.setBeds(2);
		room4.setNumber(4);
		room4.setPrice(BigDecimal.valueOf(400));
		room4.setWing(wing1);
		rooms.add(room4);

		wing1.setRooms(rooms);
		wings.add(wing1);

		floor1.setWings(wings);
		floors.add(floor1);

		hotel.setFloors(floors);
		return hotel;
	}
}
