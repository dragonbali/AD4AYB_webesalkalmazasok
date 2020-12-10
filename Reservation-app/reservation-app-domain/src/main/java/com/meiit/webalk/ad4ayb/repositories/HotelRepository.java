package com.meiit.webalk.ad4ayb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.Hotel;

@Repository
public interface HotelRepository  extends CrudRepository<Hotel, Long> {
}
