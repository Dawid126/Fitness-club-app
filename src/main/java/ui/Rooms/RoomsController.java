package ui.Rooms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.addDialogs.AddNewRoomController;
import utils.RoomManager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RoomsController {
    @FXML
    AnchorPane anchorPane;

    @FXML
    TableView<RoomInfo> roomsTableView;

    @FXML
    TableColumn<RoomInfo, String> roomsId;
    @FXML
    TableColumn<RoomInfo, String> roomsCapacity;

    ObservableList<RoomInfo> data;


    @FXML
    private void initialize(){
        initializeTableCells();
        roomsTableView.setItems(FXCollections.observableList(mapRoomsToViewModel()));
    }

    private List<RoomInfo> mapRoomsToViewModel(){
        return RoomManager
                .getInstance()
                .getRooms()
                .stream().map(RoomInfo::new)
                .collect(Collectors.toList());
    }

    private void initializeTableCells(){
        roomsId.setCellValueFactory(dataValue -> dataValue.getValue().getIdProperty());
        roomsCapacity.setCellValueFactory(dataValue -> dataValue.getValue().getCapacityProperty());
    }

    @FXML
    private void addRoom() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addNewRoom.fxml"));
        BorderPane page = null;
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        ((AddNewRoomController)loader.getController()).setDialogStage(dialogStage);
        dialogStage.setTitle("Add Client");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(stage);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        roomsTableView.setItems(FXCollections.observableList(mapRoomsToViewModel()));
    }
}
