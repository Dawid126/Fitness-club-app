package ui.Rooms;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.dialogs.DeleteDialogController;
import ui.dialogs.addDialogs.AddNewRoomController;
import ui.dialogs.editDialogs.EditClientDialogController;
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

    @FXML
    private Button deleteButton;


    ObservableList<RoomInfo> data;

    private FXMLLoader loader;
    private BorderPane page;
    private Stage dialogStage;

    @FXML
    private void initialize(){
        initializeTableCells();
        roomsTableView.setItems(FXCollections.observableList(mapRoomsToViewModel()));
        deleteButton.disableProperty().bind(
                Bindings.isEmpty(roomsTableView.getSelectionModel()
                        .getSelectedItems()));
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

    @FXML
    private void deleteRoom() {
        createDialogStage("/deleteDialog.fxml");
        ((DeleteDialogController)loader.getController()).setSelectedItem(roomsTableView.getSelectionModel().getSelectedItems().get(0).getRoom());
        ((DeleteDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Remove Room");
        dialogStage.showAndWait();
        roomsTableView.setItems(FXCollections.observableList(mapRoomsToViewModel()));
    }

    private void configureDialog(String title) {
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(anchorPane.getScene().getWindow());
        dialogStage.setScene(scene);
    }

    private void createDialogStage(String fxmlPath) {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        page = null;
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialogStage = new Stage();
    }
}
