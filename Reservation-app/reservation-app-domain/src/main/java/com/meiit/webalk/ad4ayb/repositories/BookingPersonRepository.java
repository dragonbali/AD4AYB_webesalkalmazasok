package com.meiit.webalk.ad4ayb.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.ad4ayb.BookingPerson;

@Repository
public interface BookingPersonRepository extends CrudRepository<BookingPerson, Long> {

    public BookingPerson findByEmail(String email);
}
