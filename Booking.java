import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Booking{
  private LocalDate start;
  private LocalDate end;
  private Guest guest;

  public Booking(LocalDate start, LocalDate end, Guest guest){
    this.start=start;
    this.end=end;
    this.guest=guest;
  }

  public LocalDate getStart(Booking booking){
    return this.start;
  }

  public LocalDate getEnd(Booking booking){
    return this.end;
  }

  public Guest getGuest(Booking booking){
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
