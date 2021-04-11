package Services;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;
import java.util.ArrayList;

public interface HotelPersistenceService {

    public ArrayList<Hotel> getHotelsByName(String name);
    public ArrayList<Hotel> getHotelsByCountry(String country);
    public ArrayList<Hotel> getHotelsByDate(LocalDate start, LocalDate end);
    public ArrayList<Hotel> getHotelsByGuest(Guest guest);
    public Hotel getHotelByRoom(Room room);
    public Hotel getHotelByBooking(Booking booking);
    public boolean updateBooking(Booking booking);
    public boolean insertBooking(Booking booking, Room room);

}