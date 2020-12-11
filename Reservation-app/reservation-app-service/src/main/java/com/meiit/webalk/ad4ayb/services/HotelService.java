package com.meiit.webalk.ad4ayb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.Wing;
import com.meiit.webalk.ad4ayb.repositories.FloorRepository;
import com.meiit.webalk.ad4ayb.repositories.HotelRepository;
import com.meiit.webalk.ad4ayb.repositories.RoomRepository;
import com.meiit.webalk.ad4ayb.repositories.WingRepository;
import com.meiit.webalk.ad4ayb.services.interfaces.IHotelService;

public class HotelService implements IHotelService{
	
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    FloorRepository floorRepository;
    @Autowired
    WingRepository wingRepository;
    @Autowired
    RoomRepository roomRepository;

	@Override
	public List<Hotel> getAllHotels() {
		return (List<Hotel>) hotelRepository.findAll();
	}

	@Override
	public List<Floor> getFloorsOfAHotel(Hotel hotel) {
		return floorRepository.findAllByHotel(hotel);
	}

	@Override
	public List<Wing> getWingsOfAFloor(Floor floor) {
        return wingRepository.findAllByFloor(floor);
	}

	@Override
	public List<Room> getRoomsOfAWing(Wing wing) {
		return roomRepository.findAllByWing(wing);
	}

}