package Entities;

import java.time.LocalDate;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<LocalDate[]> getAvailability() {
    return availability;
  }

  public void setAvailability(List<LocalDate[]> availability) {
    this.availability = availability;
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

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }
}