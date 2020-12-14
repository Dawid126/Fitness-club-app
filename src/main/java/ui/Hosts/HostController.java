package ui.Hosts;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
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
import utils.HostManager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HostController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button deleteButton;

    @FXML
    TableView<HostInfo> hostsTableView;

    @FXML
    TableColumn<HostInfo, String> id;

    @FXML
    TableColumn<HostInfo, String> name;

    @FXML
    TableColumn<HostInfo, String> surname;

    @FXML
    TableColumn<HostInfo, String> email;

    private FXMLLoader loader;
    private BorderPane page;
    private Stage dialogStage;

    private List<HostInfo> mapHostsToViewModel() {
        return HostManager
                .getInstance()
                .getHosts()
                .stream().map(HostInfo::new)
                .collect(Collectors.toList());
    }

    private void setTableViewProps() {
        name.setCellValueFactory(dataValue -> dataValue.getValue().nameProperty());
        surname.setCellValueFactory(dataValue -> dataValue.getValue().surnameProperty());
        email.setCellValueFactory(dataValue -> dataValue.getValue().emailProperty());
    }

    @FXML
    private void initialize() {
        setTableViewProps();
        hostsTableView.setItems(FXCollections.observableList(mapHostsToViewModel()));
        deleteButton.disableProperty().bind(
                Bindings.isEmpty(hostsTableView.getSelectionModel()
                        .getSelectedItems()));
    }

//    @FXML
//    private void addHost() {
//        createDialogStage("/addNewClient.fxml");
//        ((AddNewHostController)loader.getController()).setDialogStage(dialogStage);
//        configureDialog("Add Host");
//        dialogStage.showAndWait();
//        clientsTableView.setItems(FXCollections.observableList(mapHostsToViewModel()));
//    }

    @FXML
    private void deleteHost() {
        createDialogStage("/deleteDialog.fxml");
        ((DeleteDialogController)loader.getController()).setSelectedItem(hostsTableView.getSelectionModel().getSelectedItems().get(0).getHost());
        ((DeleteDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Remove Host");
        dialogStage.showAndWait();
        hostsTableView.setItems(FXCollections.observableList(mapHostsToViewModel()));
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
