package Entities;

import java.time.LocalDate;

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
}
