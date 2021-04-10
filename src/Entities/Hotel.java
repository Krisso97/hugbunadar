package Entities;// Bæta við importum ef þarf
import java.util.ArrayList;
import java.util.List;

public class Hotel{
  private String name;
  private String street;
  private String area;
  private String postalCode;
  private String country;
  private ArrayList<Room> rooms;

  public Hotel(String name, String street, String area, String postalCode, String country){
    this.name = name;
    this.street = street;
    this.area=area;
    this.postalCode = postalCode;
    this.country = country;
    this.rooms = new ArrayList<Room>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public void setRooms(ArrayList<Room> rooms) {
    this.rooms = rooms;
  }

  public void addRoom(Room room){
    this.rooms.add(room);
  }
}
