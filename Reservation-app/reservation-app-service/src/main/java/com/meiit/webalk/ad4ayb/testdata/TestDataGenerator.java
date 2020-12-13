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
import com.meiit.webalk.ad4ayb.User;
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
    	User user = new User("balu@balu.hu", "pass");
    	User user2 = new User("kiss@pista.hu", "pass");
    	//////////persons//////////
        BookingPerson bookingPerson = new BookingPerson( user.getEmail(), user.getPassword(), "Hornyák Balázs", 7, 
        		new BigDecimal(20000), LocalDate.of(1999, 1, 2), Currency.HUF);
        bookingPersonRepository.save(bookingPerson);
        BookingPerson bookingPerson2 = new BookingPerson( user2.getEmail(), user.getPassword(), "Kiss Pista", 8, 
        		new BigDecimal(10000), LocalDate.of(1989, 12, 2), Currency.HUF);
        bookingPersonRepository.save(bookingPerson2);
        ///////hotel1////////////
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
        
        Wing wing2 = new Wing("Quiet.",floor, WingType.EAST);
        wingRepository.save(wing2);

        Room room12 = new Room(1, 8, true, wing2, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room12);
        Room room22 = new Room(2, 3, false, wing2, new BigDecimal(1200), Currency.HUF);
        roomRepository.save(room22);
        Room room32 = new Room(3, 3, true, wing2, new BigDecimal(300), Currency.HUF);
        roomRepository.save(room32);
        Room room42 = new Room(4, 2, true, wing2, new BigDecimal(400), Currency.HUF);
        roomRepository.save(room42);
        //**//////new floor/////**//
        Floor floor2 = new Floor(2,hotel);
        floorRepository.save(floor2);
        
        Wing wing3 = new Wing("Clean.",floor2, WingType.NORTH);
        wingRepository.save(wing3);

        Room room13 = new Room(1, 2, true, wing3, new BigDecimal(600), Currency.HUF);
        roomRepository.save(room13);
        Room room23 = new Room(2, 4, false, wing3, new BigDecimal(1500), Currency.HUF);
        roomRepository.save(room23);
        Room room33 = new Room(3, 1, true, wing3, new BigDecimal(400), Currency.HUF);
        roomRepository.save(room33);
        Room room43 = new Room(4, 2, true, wing3, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room43);
        
        Wing wing4 = new Wing("Quiet.",floor2, WingType.EAST);
        wingRepository.save(wing4);

        Room room123 = new Room(1, 8, true, wing4, new BigDecimal(500), Currency.HUF);
        roomRepository.save(room123);
        Room room223 = new Room(2, 3, false, wing4, new BigDecimal(1200), Currency.HUF);
        roomRepository.save(room223);
        Room room323 = new Room(3, 3, true, wing4, new BigDecimal(300), Currency.HUF);
        roomRepository.save(room323);
        Room room423 = new Room(4, 2, true, wing4, new BigDecimal(400), Currency.HUF);
        roomRepository.save(room423);
        /////////new Hotel//////////
        Hotel hotel2 = new Hotel("Marriott","Budapest, Apáczai Csere János u. 4, 1052",5);
        hotelRepository.save(hotel2);
        //////////reservation///////
        Reservation reservation = new Reservation( new BigDecimal(100), LocalDateTime.of(2020,12,1,14,0), LocalDateTime.of(2020,12,5,10,0),
        		false, false, bookingPerson, room2);
        reservationRepository.save(reservation);
        
        System.out.println("adatbazis letrehozva");
    }
}
