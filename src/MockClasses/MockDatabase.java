package MockClasses;

import Entities.Booking;
import Entities.Guest;
import Entities.Hotel;
import Entities.Room;

import java.time.LocalDate;
import java.util.ArrayList;

public class MockDatabase {

    private static MockDatabase instance = null;
    private final ArrayList<Hotel> hotels;

    public static MockDatabase getInstance(){
        if(instance == null){
            instance = new MockDatabase();
        }
        return instance;
    }

    private MockDatabase(){
        // Create Hotel objects and add to Hotel ArrayList
        hotels = new ArrayList<Hotel>();

        // Define temporary variables to store objects
        Hotel hotel;
        Room room;
        Booking booking;

        // First hotel
        hotel = new Hotel("Test", "Test", "Test", "100A", "Iceland");
        room = new Room("303", 2, true, true,  20.2, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 11), LocalDate.of(2022, 1, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 1, 8), LocalDate.of(2022, 1, 10), new Guest("Test", "Test", "test@test.is"), room));
        room.setHotel(hotel);
        hotel.addRoom(room);
        hotels.add(hotel);

        // Second hotel
        hotel = new Hotel("Hotel Adam", "Testing", "Gullbringu", "117", "Iceland");
        room = new Room("101", 2, true, false,  100.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Jon", "Test Street", "jon@jonsson.is"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Sigurdur", "Test Street 2", "sig@sig.is"), room));
        room.setHotel(hotel);
        hotel.addRoom(room);
        hotels.add(hotel);


        // Third hotel
        hotel = new Hotel("Hotel UK", "Testing by Thames", "Essex", "17W NB2", "United Kingdom");
        room = new Room("202", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("James", "Test Street", "essexfan99@bankofengland.gov.uk"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Andy", "Test Street 2", "ukman@ukman.co.uk"), room));
        room.setHotel(hotel);
        room = new Room("204", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Boris", "Test Street 4", "prime@uk.co.uk"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Mary", "Test Street 5", "marymary@times.co.uk"), room));
        room.setHotel(hotel);
        hotel.addRoom(room);
        hotels.add(hotel);


        // Fourth hotel
        hotel = new Hotel("Hotel Tatort", "Totenweg", "Baden-Wuerttemberg", "1002AA", "Germany");
        room = new Room("202", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Jederman", "Test Street", "essexfan99@bankofengland.gov.uk"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Klaus", "Test Street 2", "ukman@ukman.co.uk"), room));
        room.setHotel(hotel);
        room = new Room("204", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Wolfgang", "Test Street", "wolfgang@motzart.at"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Amerikaner", "Test Street 2", "amerikaner@amerikaner.com"), room));
        room.setHotel(hotel);
        hotel.addRoom(room);
        hotels.add(hotel);

        // Fifth hotel
        hotel = new Hotel("Motel Geysir", "Haukadalur", "Sudurland", "300", "Iceland");
        room = new Room("202", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Amerikan", "Test Street", "america@america.com"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Norskur", "Test Street 2", "norks@norks.no"), room));
        room.setHotel(hotel);
        room = new Room("204", 2, false, false,  122.0, null);
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 1, 2), LocalDate.of(2022, 6, 7)});
        room.addAvailability(new LocalDate[]{LocalDate.of(2022, 10, 11), LocalDate.of(2022, 11, 15)});
        room.addBooking(new Booking(LocalDate.of(2022, 6, 8), LocalDate.of(2022, 8, 10), new Guest("Geir", "Test Street", "geir@jonsson.is"), room));
        room.addBooking(new Booking(LocalDate.of(2022, 8, 10), LocalDate.of(2022, 10, 9), new Guest("Danskur", "Test Street 2", "danskur@danskur.dk"), room));
        room.setHotel(hotel);
        hotel.addRoom(room);
        hotels.add(hotel);
    }


    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public void addHotel(Hotel hotel) {
        this.hotels.add(hotel);
    }
}
