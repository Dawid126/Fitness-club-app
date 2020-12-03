package ui;

import enums.WeekDay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Activity;
import javafx.scene.control.TableColumn;
import model.Room;
import model.persons.Host;
import persistence.DataManager;

import java.util.Date;

public class ActivitiesController {
    @FXML
    TableView activitiesTableView;

    @FXML
    TableColumn activitiesId;
    @FXML
    TableColumn activitiesName;
    @FXML
    TableColumn activitiesHost;
    @FXML
    TableColumn activitiesRoom;
    @FXML
    TableColumn activitiesWeekDay;
    @FXML
    TableColumn activitiesStartTime;
    @FXML
    TableColumn activitiesEndTime;

    ObservableList<Activity> data;

    DataManager dataManager = new DataManager();

    @FXML
    private void initialize(){
        data = FXCollections.observableList(dataManager.loadActivities());
        initializeTable();
    }

    private void initializeTable(){
        activitiesId.setCellValueFactory(
                new PropertyValueFactory<Activity, Integer>("id")
        );
        activitiesName.setCellValueFactory(
                new PropertyValueFactory<Activity, String>("name")
        );
        activitiesHost.setCellValueFactory(
                new PropertyValueFactory<Activity, Host>("host")
        );
        activitiesRoom.setCellValueFactory(
                new PropertyValueFactory<Activity, Room>("room")
        );
//        activitiesWeekDay.setCellValueFactory(
//                new PropertyValueFactory<Activity, WeekDay>("weekDay")
//        );
        activitiesStartTime.setCellValueFactory(
                new PropertyValueFactory<Activity, Date>("startTime")
        );
        activitiesEndTime.setCellValueFactory(
                new PropertyValueFactory<Activity, Date>("endTime")
        );

        activitiesTableView.setItems(data);
    }
}
