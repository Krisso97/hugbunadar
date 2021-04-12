package MockClasses;


import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;
import Services.HotelPersistenceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class MockHotelPersistenceImplementation implements HotelPersistenceService {

	MockDatabase database;

	public MockHotelPersistenceImplementation() {
		// Connects to database mock object
		this.database = MockDatabase.getInstance();
	}

	public ArrayList<Hotel> getAllHotels(){
		ArrayList<Hotel> hotels = database.getHotels();
		return hotels;
	}

	public ArrayList<Hotel> getHotelsByName(String name){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getName().toLowerCase().contains(name)) hotels.add(hotel);
		}
		return hotels;
	}
	
	public ArrayList<Hotel> getHotelsByCountry(String country){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getCountry().toLowerCase().contains(country)) hotels.add(hotel);
		}
		return hotels;
	}

	public ArrayList<Hotel> getHotelsByArea(String area){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getArea().toLowerCase().contains(area)) hotels.add(hotel);
		}
		return hotels;
	}
	
	public ArrayList<Hotel> getHotelsByDate(LocalDate start, LocalDate end){
		ArrayList<Hotel> hotels = new ArrayList<>();
		// Loop checks if any rooms available during the period and if
		// so adds hotel object to return array
		for(Hotel hotel: database.getHotels()){
			for(Room room: hotel.getRooms()){
				for(LocalDate[] dates: room.getAvailability()){
					if((start.isAfter(dates[0]) || start.isEqual(dates[0])) && (end.isBefore(dates[1]) || end.isEqual((dates[1])))){
						hotels.add(hotel);
					}
				}
			}
		}

		return hotels;
	}
	
	public ArrayList<Hotel> getHotelsByGuest(Guest guest){
		ArrayList<Hotel> hotels = new ArrayList<>();
		// Loop checks if guest has any bookings at any hotel
		for(Hotel hotel: database.getHotels()){
			for(Room room: hotel.getRooms()){
				for(Booking booking: room.getBookings()){
					if(guest.equals(booking.getGuest())){
						hotels.add(hotel);
					}
				}
			}
		}

		return hotels;
	}

	public Hotel getHotelByRoom(Room room){
		Hotel hotel = null;
		// Loop checks if guest has any bookings at any hotel
		for(Hotel hotelDB: database.getHotels()){
			for(Room roomDB: hotelDB.getRooms()){
				if(roomDB.equals(room)) {
					hotel = hotelDB;
					break;
				}
			}
		}

		return hotel;
	}

	public Hotel getHotelByBooking(Booking booking){
		Hotel hotel = null;
		// Loop checks if guest has any bookings at any hotel
		for(Hotel hotelDB: database.getHotels()){
			for(Room roomDB: hotelDB.getRooms()){
				for(Booking bookingDB: roomDB.getBookings()){
					if(bookingDB.equals(booking)){
						hotel = hotelDB;
						break;
					}
				}
			}
		}

		return hotel;
	}
	
	public boolean updateBooking(Booking booking){
		// TODO
		// Held við getum alveg sleppt þessu, frekar ná inn basic virkni
		return true;
	}

	// This works but is not perfect - works with one user and one thread
	// but will most likely cause collsions and fail if there are multiple
	// threads or users trying to access mock database at the same time
	// since the hotel object in room parameter might have changed since
	// the search query sent the object to the user in the first place.
	public boolean insertBooking(Booking booking, Room room){
		Hotel hotel = room.getHotel();
		for(Room roomDB: hotel.getRooms()){
			if(roomDB.equals(room)){
				// Note, free date validation is handled by the BookingService class
				roomDB.addBooking(booking);
				return true;
			}
		}
		return false;
	}

	public boolean deleteBooking(Booking booking){
		// Very messy approach, goes through everything and copies
		// every booking exept the one to be deleted. Ok for test
		// and mock object, would have to be much improved if
		// used in real database...
		for(Room roomDB: getHotelByBooking(booking).getRooms()){
			ArrayList<Booking> bookings = new ArrayList<>();
			for(Booking bookingDB: roomDB.getBookings()){
				if(!bookingDB.equals(booking)){
					bookings.add(bookingDB);
				}
			}
			roomDB.setBookings(bookings);
		}

		// Will always be successful in tests so always returns true
		return true;
	}
}