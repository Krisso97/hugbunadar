package Services;

import Entities.Booking;
import Entities.Guest;
import Entities.Room;

import java.time.LocalDate;

public class BookingService {

    HotelPersistenceService hotelPersistenceService;

    public BookingService() {
        // Mock object used for testing
        this.hotelPersistenceService = new HotelPersistenceImplementationMock();
    }

    public Booking findBookingByGuest(Guest guest, LocalDate start, LocalDate end){

    }

    public boolean makeBooking(Guest guest, LocalDate start, LocalDate end, Room room){

    }

    public boolean deleteBooking(Booking booking) {

    }

}
