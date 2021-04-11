package Controllers;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;
import Services.BookingService;
import MockClasses.MockHotelPersistenceImplementation;
import Services.HotelPersistenceService;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelSearch {
    private HotelPersistenceService hotelPersistenceService;
    private BookingService bookingService;

    public HotelSearch() {
        // Mock object used for testing
        this.hotelPersistenceService = new MockHotelPersistenceImplementation();
        this.bookingService = new BookingService();
    }

    public ArrayList<Hotel> searchByName(String name){
        return hotelPersistenceService.getHotelsByName(name);
    }

    public ArrayList<Hotel> searchByArea(String area){
        return hotelPersistenceService.getHotelsByArea(area);
    }

    public ArrayList<Hotel> searchByCountry(String country){
        return hotelPersistenceService.getHotelsByCountry(country);
    }

    public ArrayList<Hotel> searchByDate(LocalDate start, LocalDate end){
        return hotelPersistenceService.getHotelsByDate(start, end);
    }

    //TODO add more, searchByNameCountry(....)  etc.

    //TODO
    //public static compareHotels(Hotel hotelA, Hotel hotelB)

    //TODO
    //public static compareRooms(Room roomA, Room roomB)

    /*
    public static Booking findBookingByGuest(Guest guest, LocalDate start, LocalDate end){

    }*/

    public boolean bookRoom(String name, String address,
                                   String email, LocalDate start, LocalDate end, Room room){
        return bookingService.makeBooking(new Guest(name, address, email),start, end, room);
    }

    public boolean cancelRoom(String name, String address, String email, LocalDate start,
                                     LocalDate end, Room room){
        return bookingService.deleteBooking(new Booking(start, end, new Guest(name, address, email)));
    }
}
