package com.meiit.webalk.ad4ayb.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.Wing;

import java.util.List;

@Repository
public interface RoomRepository  extends CrudRepository<Room, Long> {

    public List<Room> findAllByWing(Wing wing);

}
