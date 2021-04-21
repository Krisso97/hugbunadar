package Services;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;
import MockClasses.MockHotelPersistenceImplementation;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingService {

    HotelPersistenceService hotelPersistenceService;

    public BookingService() {
        // Mock object used for testing
        this.hotelPersistenceService = new MockHotelPersistenceImplementation();
    }

    /*
    public Booking findBookingByGuest(Guest guest, LocalDate start, LocalDate end){

    }*/

    public boolean makeBooking(Guest guest, LocalDate start, LocalDate end, Room room){
        // Validates availability of room and if available inserts booking into database
        for(LocalDate[] dates: room.getAvailability()){
            if((start.isAfter(dates[0]) || start.isEqual(dates[0])) && (end.isBefore(dates[1]) || end.isEqual((dates[1])))){
                Booking booking = new Booking(start, end, guest, room);
                return hotelPersistenceService.insertBooking(booking);
            }
        }
        return false;
    }

    public boolean deleteBooking(Booking booking) {
        return hotelPersistenceService.deleteBooking(booking);
    }

}
