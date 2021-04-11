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

  @Override
  public boolean equals(Object o) {
    // Check if itself
    if (this == o)
      return true;
    // Check if null
    if (o == null)
      return false;
    // Check if same type
    if (!(o instanceof Guest))
      return false;
    // Compare attributes
    Guest guest = (Guest) o;
    if(name.equals(guest.getName()) && address.equals(guest.getAddress()) && email.equals(guest.getEmail())){
      return true;
    }else{
      return false;
    }
  }
}
