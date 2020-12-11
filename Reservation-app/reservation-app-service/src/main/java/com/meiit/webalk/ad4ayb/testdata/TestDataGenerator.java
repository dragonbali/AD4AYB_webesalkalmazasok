package com.meiit.webalk.ad4ayb.testdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.meiit.webalk.ad4ayb.BookingPerson;
import com.meiit.webalk.ad4ayb.Currency;
import com.meiit.webalk.ad4ayb.Floor;
import com.meiit.webalk.ad4ayb.Hotel;
import com.meiit.webalk.ad4ayb.Reservation;
import com.meiit.webalk.ad4ayb.Room;
import com.meiit.webalk.ad4ayb.Wing;
import com.meiit.webalk.ad4ayb.repositories.BookingPersonRepository;
import com.meiit.webalk.ad4ayb.repositories.FloorRepository;
import com.meiit.webalk.ad4ayb.repositories.HotelRepository;
import com.meiit.webalk.ad4ayb.repositories.ReservationRepository;
import com.meiit.webalk.ad4ayb.repositories.RoomRepository;
import com.meiit.webalk.ad4ayb.repositories.WingRepository;
import com.meiit.webalk.ad4ayb.WingType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TestDataGenerator implements CommandLineRunner {

	@Autowired
    private BookingPersonRepository bookingPersonRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private WingRepository wingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {
    	gerateTestData();
    }

    private void gerateTestData(){
        BookingPerson bookingPerson = new BookingPerson( "balu@balu.hu", "balu", "Hornyák Balázs", 7, 
        		new BigDecimal(20000), LocalDate.of(1999, 1, 2), Currency.HUF);
        bookingPersonRepository.save(bookingPerson);

        Hotel hotel = new Hotel("Hilton","Washington street 1.",4);
        hotelRepository.save(hotel);

        Floor floor = new Floor(1,hotel);
        floorRepository.save(floor);

        Wing wing = new Wing("Very good.",floor, WingType.NORTH);
        wingRepository.save(wing);

        Room room1 = new Room(1, 2, true, wing, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room1);
        Room room2 = new Room(2, 4, true, wing, new BigDecimal(1500), Currency.HUF);
        roomRepository.save(room2);
        Room room3 = new Room(3, 1, true, wing, new BigDecimal(200), Currency.HUF);
        roomRepository.save(room3);
        Room room4 = new Room(4, 2, true, wing, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room4);

        Reservation reservation = new Reservation( new BigDecimal(1), LocalDateTime.of(2020,12,1,14,0), LocalDateTime.of(2020,12,5,10,0),
        		false, false, bookingPerson, room2);
        reservationRepository.save(reservation);
        
        System.out.println("adatbazis letrehozva");
    }
}
