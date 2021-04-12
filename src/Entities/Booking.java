package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking{
  private LocalDate start;
  private LocalDate end;
  private Guest guest;
  private Room room;

  public Booking(LocalDate start, LocalDate end, Guest guest, Room room){
    this.start = start;
    this.end = end;
    this.guest = guest;
    this.room = room;
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

  public Room getRoom() { return room; }

  public void setStartDate(LocalDate start){
    this.start=start;
  }

  public void setEndDate(LocalDate end){
    this.end=end;
  }

  public void setGuest(Guest guest){
    this.guest=guest;
  }

  public void setRoom(Room room) { this.room = room; }

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
    return "Hotel: " + room.getHotel().getName() + ", Room: " + room.getName() + ", Guest: " + guest.getName()
            + ", From " +  start.format(formatter) + " to " + end.format(formatter);
  }
}
