package Controllers;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;
import MockClasses.MockHotelPersistenceImplementation;
import Services.BookingService;
import Services.HotelPersistenceService;

import java.time.LocalDate;
import java.util.List;

public class HotelSearch {
    private HotelPersistenceService hotelPersistenceService;
    private BookingService bookingService;

    public HotelSearch() {
        // Mock object used for testing
        this.hotelPersistenceService = new MockHotelPersistenceImplementation();
        this.bookingService = new BookingService();
    }

    public List<Hotel> getAll(){
        return hotelPersistenceService.getAllHotels();
    }
    public List<Hotel> searchByName(String name){
        return hotelPersistenceService.getHotelsByName(name.toLowerCase());
    }

    public List<Hotel> searchByArea(String area){
        return hotelPersistenceService.getHotelsByArea(area.toLowerCase());
    }

    public List<Hotel> searchByCountry(String country){
        return hotelPersistenceService.getHotelsByCountry(country.toLowerCase());
    }

    public List<Hotel> searchByDate(LocalDate start, LocalDate end){
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
        return bookingService.deleteBooking(new Booking(start, end, new Guest(name, address, email), room));
    }
}
