package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Activity;
import model.Room;
import model.persons.Host;
import persistence.DataManager;

import java.util.Date;

public class RoomsController {
    @FXML
    TableView roomsTableView;

    @FXML
    TableColumn roomsId;
    @FXML
    TableColumn roomsCapacity;
    ObservableList<Room> data;

    DataManager dataManager = new DataManager();

    @FXML
    private void initialize(){
        data = FXCollections.observableList(dataManager.loadRooms());
        initializeTable();
    }

    private void initializeTable(){
        roomsId.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("id")
        );
        roomsCapacity.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("capacity")
        );

        roomsTableView.setItems(data);
    }
}
