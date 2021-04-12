package Services;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface HotelPersistenceService {

    public List<Hotel> getAllHotels();
    public List<Hotel> getHotelsByName(String name);
    public List<Hotel> getHotelsByArea(String area);
    public List<Hotel> getHotelsByCountry(String country);
    public List<Hotel> getHotelsByDate(LocalDate start, LocalDate end);
    public List<Hotel> getHotelsByGuest(Guest guest);
    public Hotel getHotelByRoom(Room room);
    public Hotel getHotelByBooking(Booking booking);
    public Room getRoomByBooking(Booking booking);
    public boolean updateRoom(Room room);
    public boolean insertBooking(Booking booking);
    public boolean deleteBooking(Booking booking);
}