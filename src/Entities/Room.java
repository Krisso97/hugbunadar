package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Room{

  private String name;
  private List<LocalDate[]> availability;
  private int beds;
  private boolean aircon;
  private boolean shower;
  private Double price;
  private List<Booking> bookings;
  private Hotel hotel;

  public Room(String name, int beds, boolean aircon,
    boolean shower, Double price, Hotel hotel){
      this.name = name;
      this.availability = new ArrayList<LocalDate[]>();
      this.beds = beds;
      this.aircon = aircon;
      this.shower = shower;
      this.price = price;
      this.bookings = new ArrayList<Booking>();
      this.hotel = hotel;
    }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<LocalDate[]> getAvailability() {
    return availability;
  }

  public void setAvailability(ArrayList<LocalDate[]> availability) {
    this.availability = availability;
  }

  public void addAvailability(LocalDate[] availability){
    this.availability.add(availability);
  }

  public int getBeds() {
    return beds;
  }

  public void setBeds(int beds) {
    this.beds = beds;
  }

  public boolean isAircon() {
    return aircon;
  }

  public void setAircon(boolean aircon) {
    this.aircon = aircon;
  }

  public boolean isShower() {
    return shower;
  }

  public void setShower(boolean shower) {
    this.shower = shower;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<Booking> getBookings() {
    return bookings;
  }

  public void setBookings(ArrayList<Booking> bookings) {
    this.bookings = bookings;
  }

  public void addBooking(Booking booking){
    this.bookings.add(booking);
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  @Override
  public boolean equals(Object o) {
    // Check if itself
    if (this == o)
      return true;
    // Check if null
    if (o == null)
      return false;
    // Check if same type
    if (!(o instanceof Room))
      return false;
    // Compare attributes
    Room room = (Room) o;
    if(name.equals(room.getName()) && availability.equals(room.getAvailability()) && (beds == room.getBeds())
       && (aircon == room.isAircon()) && (shower == room.isShower()) && (price == room.getPrice())
       && bookings.equals(room.getBookings()) && hotel.equals(room.getHotel())){
      return true;
    }else{
      return false;
    }
  }

  @Override
  public String toString() {
    String availString = "";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    for(LocalDate[] dates:availability){
      availString = availString + ", " + dates[0].format(formatter) + " to " + dates[1].format(formatter);
    }

    return name + " is free on:" + availString.substring(1);
  }
}
