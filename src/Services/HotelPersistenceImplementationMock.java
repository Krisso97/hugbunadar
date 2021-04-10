package Services;


import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HotelPersistenceImplementationMock implements HotelPersistenceService {

	// Initialize mock object to return
	Guest guest = new Guest("Test", "Test", "test@test.is");
	
	Booking booking = new Booking(LocalDate.of(2022, 1, 8), LocalDate.of(2022, 1, 10), guest);
	
	List<LocalDate[]> availability = Arrays.asList(new LocalDate[]{LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 7)}, new LocalDate[]{LocalDate.of(2022, 1, 11), LocalDate.of(2022, 1, 15)});
	
	Room room = new Room("Test", "Test", availability, 2, true, true, 20.2,  Arrays.asList(booking), null);
	
	Hotel hotel = new Hotel("Test", "Test", "Test", "100A", "Iceland", Arrays.asList(room));
	         
	room.setHotel(hotel);
	
	
	public Hotel[] getHotelsByName(String name){
		Hotel hotel = this.hotel;
		hotel.setName = name;
		
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getHotelsByCountry(String country){
		Hotel hotel = this.hotel;
		hotel.setCountry = country;
		
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getByDate(LocalDate start, LocalDate end){
		Hotel hotel = this.hotel;
		Room room = this.room;
		
		List<LocalDate[]> availability = Arrays.asList(new LocalDate[]{start, end});
		room.setAvailability(availability);
		hotel.setRooms(Arrays.asList(room));
		
		return new Hotel[]{hotel};
	}
	
	public Hotel[] getByGuest(Guest guest){
		Hotel hotel = this.hotel;
		Room room  = this.room;
		Booking booking = this.booking;
		
		booking.setGuest(guest);
		room.setBooking(Arrays.asList(booking));
		hotel.setRooms(Arrays.asList(room));
		
		return new Hotel[]{hotel};
	}
	
	public Hotel getByRoom(Room room){
		Hotel hotel = this.hotel;
		hotel.setRooms(Arrays.asList(room));
		
		return Hotel;
	}
	
	public boolean updateBooking(Booking booking){
		return
	}
	
	public boolean insertBooking(Booking booking){
	}
	
	public boolean update(Room room){
		return
	}
	
	public boolean insertRoom(Room room){
		return
	}
	
}