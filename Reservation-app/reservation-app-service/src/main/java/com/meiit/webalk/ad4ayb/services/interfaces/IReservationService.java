package com.meiit.webalk.ad4ayb.services.interfaces;

import java.util.List;

import com.meiit.webalk.ad4ayb.Reservation;

public interface IReservationService {

	public List<Reservation> findReservationsByEmail(String email);
	public void saveReservation(Reservation reservation);
    public void deleteReservation(Reservation reservation);
}
