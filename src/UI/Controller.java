package UI;

import Controllers.HotelSearch;
import Entities.Booking;
import Entities.Hotel;
import Entities.Room;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class Controller implements Initializable {
    @FXML
    private TextField nameSearchField;
    @FXML
    private TextField areaSearchField;
    @FXML
    private TextField countrySearchField;
    @FXML
    private TextField nameBookingField;
    @FXML
    private TextField addressBookingField;
    @FXML
    private TextField emailBookingField;

    @FXML
    private DatePicker startSearchDatePicker;
    @FXML
    private DatePicker endSearchDatePicker;
    @FXML
    private DatePicker startBookingDatePicker;
    @FXML
    private DatePicker endBookingDatePicker;

    @FXML
    private Button nameSearchBtn;
    @FXML
    private Button areaSearchBtn;
    @FXML
    private Button countrySearchBtn;
    @FXML
    private Button dateSearchBtn;
    @FXML
    private Button createBookingBtn;

    @FXML
    private ListView hotelsListView;
    @FXML
    private ListView roomsListView;
    @FXML
    private ListView bookingsListView;

    private HotelSearch hotelSearch;

    private ObservableList<Booking> activeBookings;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hotelSearch = new HotelSearch();
        activeBookings = FXCollections.observableArrayList();
        getActiveBookings();
        bookingsListView.setItems(activeBookings);
    }



    public void nameSearchBtnClicked(MouseEvent mouseEvent){
        String name = nameSearchField.getText();
        roomsListView.setItems(null);
        hotelsListView.setItems(FXCollections.observableList(hotelSearch.searchByName(name)));
    }

    public void areaSearchBtnClicked(MouseEvent mouseEvent){
        String area = areaSearchField.getText();
        roomsListView.setItems(null);
        hotelsListView.setItems(FXCollections.observableList(hotelSearch.searchByArea(area)));
    }

    public void countrySearchBtnClicked(MouseEvent mouseEvent){
        String country = countrySearchField.getText();
        roomsListView.setItems(null);
        hotelsListView.setItems(FXCollections.observableList(hotelSearch.searchByCountry(country)));
    }

    public void dateSearchBtnClicked(MouseEvent mouseEvent){
        LocalDate start = startSearchDatePicker.getValue();
        LocalDate end = endSearchDatePicker.getValue();
        roomsListView.setItems(null);
        hotelsListView.setItems(FXCollections.observableList(hotelSearch.searchByDate(start, end)));
    }

    public void hotelsListViewClicked(MouseEvent mouseEvent) {
        Hotel hotel = (Hotel) hotelsListView.getSelectionModel().getSelectedItem();
        if(hotel == null){
            roomsListView.setItems(null);
        }else{
            roomsListView.setItems(FXCollections.observableList(hotel.getRooms()));
        }
    }


    public void createBookingBtnClicked(MouseEvent mouseEvent){
        String name = nameBookingField.getText();
        String address = addressBookingField.getText();
        String email = emailBookingField.getText();
        LocalDate start = startBookingDatePicker.getValue();
        LocalDate end = endBookingDatePicker.getValue();
        Room room = (Room) roomsListView.getSelectionModel().getSelectedItem();

        if((name != null) && (address != null) && (email != null) && (start != null) &&
                (end != null) && (room != null)){
            hotelSearch.bookRoom(name, address, email, start, end, room);
            getActiveBookings();
        }
    }

    public void getActiveBookings(){
        for(Hotel hotel: hotelSearch.getAll()){
            for(Room room: hotel.getRooms()){
                for(Booking booking: room.getBookings()){
                    if(!activeBookings.contains(booking)){
                        activeBookings.add(booking);
                    }
                }
            }
        }
    }



}
