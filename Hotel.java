// Bæta við importum ef þarf
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Hotel{
  private String name;
  private String street;
  private String area;
  private String postalCode;
  private String country;
  private List<Room> rooms;

  public Hotel(String name, String street, String area, String postalCode, String country, List<Room> rooms){
    this.name = name;
    this.street = street;
    this.area=area;
    this.postalCode = postalCode;
    this.country = country;
    this.rooms = rooms;
  }

  public String getHotelName(Hotel hotel){
    return this.name;
  }

  public String getStreetName(Hotel hotel){
    return this.street;
  }

  public String getArea(Hotel hotel){
    return this.area;
  }

  public String getPostalCode(Hotel hotel){
    return this.postalCode;
  }

  public String getCountry(Hotel hotel){
    return this.country;
  }

  public List<Room> getRooms(Hotel hotel){
    return this.rooms;
  }

  public void setHotelName(String name){
    this.name=name;
  }

  public void setStreetName(String street){
    this.street=street;
  }

  public void setArea(String area){
    this.area=area;
  }

  public void setPostalCode(String postalCode){
    this.postalCode=postalCode;
  }

  public void setCountry(String country){
    this.country=country;
  }

}
