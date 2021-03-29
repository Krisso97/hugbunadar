import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Guest{

  private String name;
  private String address;
  private String email;


  public Guest(String name, String address, String email){
    this.name=name;
    this.address=address;
    this.email=email;
  }

  public String getGuestName(Guest guest){
    return this.name;
  }

  public String getGuestAddress(Guest guest){
    return this.address;
  }

  public String getGuestEmail(Guest guest){
    return this.email;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public void setEmail(String email){
    this.email=email;
  }
}
