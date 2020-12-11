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

    private BookingPersonRepository bookingPersonRepository;
    private HotelRepository hotelRepository;
    private FloorRepository floorRepository;
    private WingRepository wingRepository;
    private RoomRepository roomRepository;
    
    @Autowired
    public void setBookingPersonRepository(BookingPersonRepository bookingPersonRepository) {
		this.bookingPersonRepository = bookingPersonRepository;
	}

    @Autowired
	public void setHotelRepository(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

    @Autowired
	public void setFloorRepository(FloorRepository floorRepository) {
		this.floorRepository = floorRepository;
	}

    @Autowired
	public void setWingRepository(WingRepository wingRepository) {
		this.wingRepository = wingRepository;
	}

    @Autowired
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

    @Autowired
	public void setReservationRepository(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

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

        Hotel hotel = new Hotel("Hilton","Budapest, Hess András tér 1-3, 1014",5);
        hotelRepository.save(hotel);

        Floor floor = new Floor(1,hotel);
        floorRepository.save(floor);

        Wing wing = new Wing("Clean.",floor, WingType.NORTH);
        wingRepository.save(wing);

        Room room1 = new Room(1, 2, true, wing, new BigDecimal(600), Currency.HUF);
        roomRepository.save(room1);
        Room room2 = new Room(2, 4, false, wing, new BigDecimal(1500), Currency.HUF);
        roomRepository.save(room2);
        Room room3 = new Room(3, 1, true, wing, new BigDecimal(400), Currency.HUF);
        roomRepository.save(room3);
        Room room4 = new Room(4, 2, true, wing, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room4);

        Reservation reservation = new Reservation( new BigDecimal(1), LocalDateTime.of(2020,12,1,14,0), LocalDateTime.of(2020,12,5,10,0),
        		false, false, bookingPerson, room2);
        reservationRepository.save(reservation);
        
        System.out.println("adatbazis letrehozva");
    }
}
