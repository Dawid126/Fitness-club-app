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
import ui.dialogs.editDialogs.EditClientDialogController;
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
    private Button editButton;

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

    private FXMLLoader loader;
    private BorderPane page;
    private Stage dialogStage;

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
        editButton.disableProperty().bind(
                Bindings.isEmpty(clientsTableView.getSelectionModel()
                        .getSelectedItems()));
    }

    @FXML
    private void addClient() {
        createDialogStage("/addNewClient.fxml");
        ((AddNewClientController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Add Client");
        dialogStage.showAndWait();
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
    }

    @FXML
    private void deleteClient() {
        createDialogStage("/deleteDialog.fxml");
        ((DeleteDialogController)loader.getController()).setSelectedItem(clientsTableView.getSelectionModel().getSelectedItems().get(0).getClient());
        ((DeleteDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Remove Client");
        dialogStage.showAndWait();
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
    }

    @FXML
    private void editClient() {
        createDialogStage("/editClient.fxml");
        ((EditClientDialogController)loader.getController()).setSelectedClient(clientsTableView.getSelectionModel().getSelectedItems().get(0).getClient());
        ((EditClientDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Edit Client");
        dialogStage.showAndWait();
        clientsTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
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
