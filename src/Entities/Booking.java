package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking{
  private LocalDate start;
  private LocalDate end;
  private Guest guest;

  public Booking(LocalDate start, LocalDate end, Guest guest){
    this.start=start;
    this.end=end;
    this.guest=guest;
  }

  public LocalDate getStart(){
    return this.start;
  }

  public LocalDate getEnd(){
    return this.end;
  }

  public Guest getGuest(){
    return this.guest;
  }

  public void setStartDate(LocalDate start){
    this.start=start;
  }

  public void setEndDate(LocalDate end){
    this.end=end;
  }

  public void setGuest(Guest guest){
    this.guest=guest;
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
    if (!(o instanceof Booking))
      return false;
    // Compare attributes
    Booking booking = (Booking) o;
    if(start.isEqual(booking.getStart()) && end.isEqual(booking.getEnd()) && guest.equals(booking.getGuest())){
      return true;
    }else{
      return false;
    }
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return guest.getName() + ", from " +  start.format(formatter) + " to " + end.format(formatter);
  }
}
