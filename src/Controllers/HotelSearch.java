package Controllers;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;

public class HotelSearch {
    public static Hotel[] searchByName(String name){

    }

    public static Hotel[] searchByArea(String area){

    }

    public static Hotel[] searchByCountry(String country){

    }

    public static Hotel[] searchByDate(LocalDate start, LocalDate end){

    }

    //TODO add more, searchByNameCountry(....)  etc.

    //TODO
    //public static compareHotels(Hotel hotelA, Hotel hotelB)

    //TODO
    //public static compareRooms(Room roomA, Room roomB)


    public static Booking findBookingByGuest(Guest guest, LocalDate start, LocalDate end){

    }

    public static boolean bookRoom(String name, String address,
                                   String email, LocalDate start, LocalDate end, Room room){

    }

    public static boolean cancelRoom(String name, String address, String email, LocalDate start,
                                     LocalDate end, Room room){

    }
}