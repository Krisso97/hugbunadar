package Services;


import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class HotelPersistenceImplementationMock implements HotelPersistenceService {

	Guest guest;
	Booking booking;
	Room room;
	Hotel hotel;

	public HotelPersistenceImplementationMock() {
		// Initialize mock object template
		this.guest = new Guest("Test", "Test", "test@test.is");
		this.booking = new Booking(LocalDate.of(2022, 1, 8), LocalDate.of(2022, 1, 10), guest);

		ArrayList<LocalDate[]> availability = new ArrayList<LocalDate[]>();
		availability.add(new LocalDate[]{LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 7)});
		availability.add(new LocalDate[]{LocalDate.of(2022, 1, 11), LocalDate.of(2022, 1, 15)});

		this.room = new Room("Test", 2, true, true,  20.2, null);
		this.room.setAvailability(availability);
		this.hotel = new Hotel("Test", "Test", "Test", "100A", "Iceland");

		this.hotel.addRoom(this.room);
		this.room.setHotel(this.hotel);
	}

	private Guest copyGuest(Guest guest){
		return new Guest(guest.getName(), guest.getAddress(), guest.getEmail());
	}

	private Booking copyBooking(Booking booking){
		return new Booking(booking.getStart(), booking.getEnd(), booking.getGuest());
	}

	private Room copyRoom(Room room){
		Room roomCopy = new Room(room.getName(), room.getBeds(), room.isAircon(), room.isShower(),
								room.getPrice(), room.getHotel());
		roomCopy.addAvailability(room.getAvailability().get(0));
		roomCopy.addBooking(room.getBookings().get(0));
		return roomCopy;
	}

	private Hotel copyHotel(Hotel hotel){
		Hotel hotelCopy = new Hotel(hotel.getName(), hotel.getStreet(),hotel.getArea(),
									hotel.getPostalCode(), hotel.getCountry());
		hotelCopy.addRoom(hotel.getRooms().get(0));
		return hotelCopy;
	}


	public Hotel[] getHotelsByName(String name){
		// Copies mock object template
		Hotel hotel = copyHotel(this.hotel);
		// Replaces name by search criteria
		hotel.setName(name);
		// Returns modified hotel object
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getHotelsByCountry(String country){
		// Copies mock object template
		Hotel hotel = copyHotel(this.hotel);
		// Replaces name by search criteria
		hotel.setCountry(country);
		// Returns modified hotel object
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getHotelsByDate(LocalDate start, LocalDate end){
		// Copies mock object templates
		Hotel hotel = copyHotel(this.hotel);
		Room room = copyRoom(this.room);

		// Replaces availability of room by search criteria
		ArrayList<LocalDate[]> availability = new ArrayList<LocalDate[]>();
		availability.add(new LocalDate[]{start, end});
		room.setAvailability(availability);

		//Replaces list of rooms in Hotel by new room object which is available
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(room);
		hotel.setRooms(rooms);

		// Returns modified hotel object
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getHotelsByGuest(Guest guest){
		// Copies mock object templates
		Hotel hotel = copyHotel(this.hotel);
		Room room  = copyRoom(this.room);
		Booking booking = copyBooking(this.booking);
		
		//Replaces guest on booking by search criteria
		booking.setGuest(guest);
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		bookings.add(booking);
		// Replaces booking on room by modified booking
		room.setBookings(bookings);
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(room);
		// Replaces room in hotel by modified room
		hotel.setRooms(rooms);

		// Returns modified hotel object
		return new Hotel[]{hotel};
	}
	
	public Hotel getHotelByRoom(Room room){
		// Copies mock object templates
		Hotel hotel = copyHotel(this.hotel);

		// Replaces rooms in hotel by search criteria
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(room);
		// Replaces room in hotel by modified room
		hotel.setRooms(rooms);

		// Returns modified hotel object
		return hotel;
	}
	
	public boolean updateBooking(Booking booking){
		//TODO
		// In actual persistence service this would just update table in database
		// Validation handled by BookingService!
		return true;
	}
	
	public boolean insertBooking(Booking booking){
		//TODO
		// In actual persistence service this would just update table in database
		// Validation handled by BookingService!
		return true;
	}
	
}