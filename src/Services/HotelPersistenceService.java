package Services;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;

public interface HotelPersistenceService {

    public Hotel[] getHotelsByName(String name);
    public Hotel[] getHotelsByCountry(String country);
    public Hotel[] getHotelsByDate(LocalDate start, LocalDate end);
    public Hotel[] getHotelsByGuest(Guest guest);
    public Hotel getHotelByRoom(Room room);
    public boolean updateBooking(Booking booking);
    public boolean insertBooking(Booking booking);

}