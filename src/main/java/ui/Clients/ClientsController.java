package ui.Clients;

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
import ui.dialogs.addDialogs.AddNewClientController;
import utils.ClientManager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ClientsController {
    @FXML
    private Button add;

    @FXML
    private Button deleteButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<ClientInfo> clientsTableView;

    @FXML
    private TableColumn<ClientInfo, String> name;

    @FXML
    private TableColumn<ClientInfo, String> surname;

    @FXML
    private TableColumn<ClientInfo, String> email;

    public ClientsController() {

    }

    private List<ClientInfo> mapClientsToViewModel() {
        return ClientManager
                .getInstance()
                .getClients()
                .stream().map(ClientInfo::new)
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
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
        System.out.println(mapClientsToViewModel().size());
        deleteButton.disableProperty().bind(
                Bindings.isEmpty(clientsTableView.getSelectionModel()
                        .getSelectedItems()));
    }

    @FXML
    private void addClient() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addNewClient.fxml"));
        BorderPane page = null;
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        ((AddNewClientController)loader.getController()).setDialogStage(dialogStage);
        dialogStage.setTitle("Add Client");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(stage);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
    }

    @FXML
    private void deleteClient() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/deleteDialog.fxml"));
        BorderPane page = null;
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        ((DeleteDialogController)loader.getController()).setSelectedClient(clientsTableView.getSelectionModel().getSelectedItems().get(0).getClient());
        ((DeleteDialogController)loader.getController()).setDialogStage(dialogStage);
        dialogStage.setTitle("Remove Client");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(stage);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
    }
}
