package com.meiit.webalk.ad4ayb.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Hotel;

import java.util.List;

@Repository
public interface FloorRepository  extends CrudRepository<Floor, Long> {

    public List<Floor> findAllByHotel(Hotel hotel);
}
