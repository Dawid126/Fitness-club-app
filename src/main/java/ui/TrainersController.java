package ui;

import enums.WeekDay;
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

public class TrainersController {
    @FXML
    TableView trainersTableView;

    @FXML
    TableColumn trainersId;
    @FXML
    TableColumn trainersName;
    @FXML
    TableColumn trainersSurname;
    @FXML
    TableColumn trainersEmail;

    ObservableList<Host> data;

    DataManager dataManager = new DataManager();

    @FXML
    private void initialize() {
        data = FXCollections.observableList(dataManager.loadHosts());
        initializeTable();
    }

    private void initializeTable() {
//        trainersId.setCellValueFactory(
//                new PropertyValueFactory<Activity, Integer>("id")
//        );
        trainersName.setCellValueFactory(
                new PropertyValueFactory<Activity, String>("name")
        );
        trainersSurname.setCellValueFactory(
                new PropertyValueFactory<Activity, String>("surname")
        );
        trainersEmail.setCellValueFactory(
                new PropertyValueFactory<Activity, String>("email")
        );

        trainersTableView.setItems(data);
    }
}
