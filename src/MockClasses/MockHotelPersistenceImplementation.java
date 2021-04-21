package MockClasses;


import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;
import Services.HotelPersistenceService;

import java.time.LocalDate;
import java.util.*;

public class MockHotelPersistenceImplementation implements HotelPersistenceService {

	MockDatabase database;

	public MockHotelPersistenceImplementation() {
		// Connects to database mock object
		this.database = MockDatabase.getInstance();
	}

	public List<Hotel> getAllHotels(){
		ArrayList<Hotel> hotels = database.getHotels();
		return hotels;
	}

	public List<Hotel> getHotelsByName(String name){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getName().toLowerCase().contains(name)) hotels.add(hotel);
		}
		return hotels;
	}
	
	public List<Hotel> getHotelsByCountry(String country){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getCountry().toLowerCase().contains(country)) hotels.add(hotel);
		}
		return hotels;
	}

	public List<Hotel> getHotelsByArea(String area){
		ArrayList<Hotel> hotels = new ArrayList<>();
		for(Hotel hotel: database.getHotels()){
			if(hotel.getArea().toLowerCase().contains(area)) hotels.add(hotel);
		}
		return hotels;
	}
	
	public List<Hotel> getHotelsByDate(LocalDate start, LocalDate end){
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
	
	public List<Hotel> getHotelsByGuest(Guest guest){
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

	public Room getRoomByBooking(Booking booking){
		return booking.getRoom();
	}


	public boolean updateRoom(Room room){
		Hotel updatedHotel = null;
		for(Hotel hotelDB: database.getHotels()){
			for(Room roomDB: hotelDB.getRooms()){
				if(roomDB.equals(room)){
					updatedHotel = hotelDB;
				}
			}

		}
		if(updatedHotel == null){
			return false;
		}else{
			ArrayList<Room> updatedRooms = new ArrayList<>();
			for(Room roomDB: updatedHotel.getRooms()){
				if(roomDB.equals(room)){
					updatedRooms.add(room);
				}else{
					updatedRooms.add(roomDB);
				}
			}
			updatedHotel.setRooms(updatedRooms);
			return true;
		}
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
	public boolean insertBooking(Booking booking){
		Room room = booking.getRoom();
		Hotel hotel = room.getHotel();

		for(Hotel hotelDB: database.getHotels()) {
			if (hotelDB.equals(hotel)) {
				for (Room roomDB : hotelDB.getRooms()) {
					if (roomDB.equals(room)) {
						// Note, free date validation is handled by the BookingService class
						roomDB.addBooking(booking);
						// Updates availability of room to reflect new booking
						ArrayList<LocalDate[]> newAvailability = new ArrayList<>();
						for (LocalDate[] dates : roomDB.getAvailability()) {
							if (dates[0].isBefore(booking.getStart()) && dates[1].isAfter(booking.getEnd())) {
								// If within availabilty period then partion into two halves
								LocalDate[] lowerPartion = {dates[0], booking.getStart().minusDays(1)};
								LocalDate[] upperPartion = {booking.getEnd().plusDays(1), dates[1]};
								newAvailability.add(lowerPartion);
								newAvailability.add(upperPartion);
							} else if (dates[0].isBefore(booking.getStart()) && dates[1].isEqual(booking.getEnd())) {
								// If matches end of availabilty period then cut of end
								LocalDate[] lowerPartion = {dates[0], booking.getStart().minusDays(1)};
								newAvailability.add(lowerPartion);
							} else if (dates[0].isEqual(booking.getStart()) && dates[1].isAfter(booking.getEnd())) {
								// If matches start of availabilty period then cut of start
								LocalDate[] upperPartion = {booking.getEnd().plusDays(1), dates[1]};
								newAvailability.add(upperPartion);
							} else if (dates[0].isEqual(booking.getStart()) && dates[1].isEqual(booking.getEnd())) {
								// If matches availability period then it is removed.
								// Do nothing - will not be added to newAvailability since booking covers whole
								// availability period
							} else {
								// Add other older availabilities to new list
								newAvailability.add(dates);
							}
						}
						roomDB.setAvailability(newAvailability);
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean deleteBooking(Booking booking){
		Room room = booking.getRoom();
		Hotel hotel = room.getHotel();
		database.getHotels();
		for(Hotel hotelDB: database.getHotels()){
			if(hotelDB.equals(hotel)) {
				for (Room roomDB : hotelDB.getRooms()) {
					if (roomDB.equals(room)) {
						// Removes booking
						roomDB.removeBooking(booking);

						// Updates availability of room to reflect new booking
						// Create queue to manage older availability values
						ArrayList<LocalDate[]> newAvailability = new ArrayList<>();
						ArrayList<LocalDate[]> oldAvailability = new ArrayList<>(roomDB.getAvailability());

						if (oldAvailability.isEmpty()) {
							// Handles outlier where Room availability list empty
							newAvailability.add(new LocalDate[]{booking.getStart(), booking.getEnd()});
						} else if (oldAvailability.get(0)[0].isAfter(booking.getEnd())) {
							// Handles outlier where Room available before first availability in list
							newAvailability.add(new LocalDate[]{booking.getStart(), booking.getEnd()});
							newAvailability.addAll(oldAvailability);
						}
						else if (oldAvailability.get(oldAvailability.size() - 1)[1].isBefore(booking.getStart())) {
							// Handles outlier where Room available after last availability in list
							newAvailability = oldAvailability;
							newAvailability.add(new LocalDate[]{booking.getStart(), booking.getEnd()});
						}
						else {
							// Puts newly freed availability in correct position
							newAvailability.add(oldAvailability.get(0));
							for(int i = 0; i < oldAvailability.size(); i++){
								if(oldAvailability.get(i)[1].isBefore(booking.getStart())){
									newAvailability.add(new LocalDate[]{booking.getStart(), booking.getEnd()});
								}
								else {
									newAvailability.add(new LocalDate[]{oldAvailability.get(i)[0], oldAvailability.get(i)[1]});
								}
							}
						}

						/* else if (oldAvailability.get(oldAvailability.size() - 1)[1].isBefore(booking.getStart())) {
							// Handles outlier where Room available after last availability in list
							newAvailability = oldAvailability;
							newAvailability.add(new LocalDate[]{booking.getStart(), booking.getEnd()});
						} else {
							// Loops through list and finds where to position new availability
							System.out.println("Er komið hingað");
							for (int i = 0; i < oldAvailability.size() - 1; i ++) {
								if (oldAvailability.get(i)[1].equals(booking.getStart().minusDays(1)) && oldAvailability.get(i + 1)[0].equals(booking.getEnd().plusDays(1))) {
									// If fits between two availability periods then merge all three into one
									newAvailability.add(new LocalDate[]{oldAvailability.get(i)[0], oldAvailability.get(i + 1)[1]});
									System.out.println("Segir sé milli");
								} else if (oldAvailability.get(i)[1].equals(booking.getStart().minusDays(1)) && !oldAvailability.get(i + 1)[0].equals(booking.getEnd().plusDays(1))) {
									// If touches end of earlier availability period but not start of next then  add to earlier availabilty
									newAvailability.add(new LocalDate[]{oldAvailability.get(i)[0], booking.getEnd()});
									newAvailability.add(new LocalDate[]{oldAvailability.get(i + 1)[0], oldAvailability.get(i + 1)[1]});
									System.out.println("Fyrri tengist");
								} else if (!oldAvailability.get(i)[1].equals(booking.getStart().minusDays(1)) && oldAvailability.get(i + 1)[0].equals(booking.getEnd().plusDays(1))) {
									// If touches start of later availability period but not end of previous one then add to later availabilty
									newAvailability.add(new LocalDate[]{oldAvailability.get(i)[0], oldAvailability.get(i)[1]});
									newAvailability.add(new LocalDate[]{booking.getStart(), oldAvailability.get(i + 1)[1]});
									System.out.println("Seinni tengist");
								} else {
									// For other availabilities just add unchanged to new list
									newAvailability.add(new LocalDate[]{oldAvailability.get(i)[0], oldAvailability.get(i)[1]});
									newAvailability.add(new LocalDate[]{oldAvailability.get(i + 1)[0], oldAvailability.get(i + 1)[1]});
									System.out.println("increment liðurinn");
								}
							}
						}
						*/

						ArrayList<LocalDate[]> newAvailabilityMerged = new ArrayList<>();
						// Runs through new Availability and merges all touching availabilities
						newAvailabilityMerged.add(newAvailability.get(0));
						int indexMerged = 0;
						for (int i = 1; i < newAvailability.size(); i++) {
							if (newAvailabilityMerged.get(indexMerged)[1].equals(newAvailability.get(i)[0].minusDays(1))) {
								newAvailabilityMerged.set(indexMerged, new LocalDate[]{newAvailabilityMerged.get(indexMerged)[0], newAvailability.get(i)[1]});
							} else {
								newAvailabilityMerged.add(new LocalDate[]{newAvailability.get(i)[0], newAvailability.get(i)[1]});
								indexMerged++;
							}
						}


						// Finds hotel and room in database and sets new booking list
						// and availability
						roomDB.setAvailability(newAvailabilityMerged);
						return true;
					}
				}
			}
		}
		return false;
	}
}