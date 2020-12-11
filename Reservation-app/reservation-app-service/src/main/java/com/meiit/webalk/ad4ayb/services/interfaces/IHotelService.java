package com.meiit.webalk.ad4ayb.services.interfaces;

import java.util.List;

import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.Wing;

public interface IHotelService {

    public List<Hotel> getAllHotels();
    public List<Floor> getFloorsOfAHotel(Hotel hotel);
    public List<Wing> getWingsOfAFloor(Floor floor);
    public List<Room> getRoomsOfAWing(Wing wing);
}
