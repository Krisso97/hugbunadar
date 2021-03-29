import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;


public class Room{

  private String name;
  private List<LocalDate[]> availability;
  private int beds;
  private boolean aircon;
  private boolean shower;
  private Double price;
  private List<Booking> bookings;
  private Hotel hotel;

  public Room(String name, List<LocalDate[]> availability, int beds, boolean aircon,
    boolean shower, Double price, List<Booking> bookings, Hotel hotel){
      this.name=name;
      this.availability=availability;
      this.beds=beds;
      this.aircon=aircon;
      this.shower=shower;
      this.price=price;
      this.bookings=bookings;
      this.hotel=hotel;
    }

    public String getRoomName(Room room){
      return this.name;
    }

    public List<LocalDate[]> getRoomAvailability(Room room){
      return this.availability;
    }

    public int getRoomBeds(Room room){
      return this.beds;
    }

    public boolean getRoomAircon(Room room){
      return this.aircon;
    }

    public boolean getRoomShower(Room room){
      return this.shower;
    }

    public Double getRoomPrice(Room room){
      return this.price;
    }

    public List<Booking> getRoomBookings(Room room){
      return this.bookings;
    }

    public Hotel getRoomHotel(Room room){
      return this.hotel;
    }

    public void setRoomName(String name){
      this.name=name;
    }

    public void setRoomAvailability(List<LocalDate[]> availability){
      this.availability=availability;
    }

    public void setRoomBeds(int beds){
      this.beds=beds;
    }

    public void setRoomAircon(boolean aircon){
      this.aircon=aircon;
    }

    public void setRoomShower(boolean shower){
      this.shower=shower;
    }

    public void setRoomPrice(Double price){
      this.price=price;
    }

    public void setRoomBookings(List<Booking> bookings){
      this.bookings=bookings;
    }

    public void setRoomHotel(Hotel hotel){
      this.hotel=hotel;
    }

}
