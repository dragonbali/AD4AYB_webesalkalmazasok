package com.meiit.webalk.ad4ayb.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Wing;

import java.util.List;

@Repository
public interface WingRepository extends CrudRepository<Wing, Long> {

    public List<Wing> findAllByFloor(Floor floor);
    public Wing getById(Long id);
}
