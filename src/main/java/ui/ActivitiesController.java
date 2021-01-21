package ui;

import enums.Role;
import enums.WeekDay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Activity;
import javafx.scene.control.TableColumn;
import model.Room;
import model.persons.Host;
import persistence.DataManager;
import utils.ActivityManager;
import utils.LoginManager;
import utils.RoomManager;

import java.util.Date;

public class ActivitiesController {
    @FXML
    public SplitPane splitPane;
    @FXML
    public AnchorPane sidebar;
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


    @FXML
    private void initialize(){
        authoriseRole();
        data = FXCollections.observableList(ActivityManager.getInstance().getActivities());
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
        activitiesWeekDay.setCellValueFactory(
                new PropertyValueFactory<Activity, WeekDay>("weekDay")
        );
        activitiesStartTime.setCellValueFactory(
                new PropertyValueFactory<Activity, Date>("startTime")
        );
        activitiesEndTime.setCellValueFactory(
                new PropertyValueFactory<Activity, Date>("endTime")
        );

        activitiesTableView.setItems(data);
    }

    private void authoriseRole(){
        Role role = LoginManager.getInstance().getLoggedUser().getRole();

        switch (role){
            case RECEPTIONIST, ADMIN -> {
                splitPane.getItems().remove(sidebar);
            }
        }
    }
}
