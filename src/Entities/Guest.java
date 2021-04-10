package Entities;

public class Guest{

  private String name;
  private String address;
  private String email;


  public Guest(String name, String address, String email){
    this.name=name;
    this.address=address;
    this.email=email;
  }

  public String getName(){
    return this.name;
  }

  public String getAddress(){
    return this.address;
  }

  public String getEmail(){
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
