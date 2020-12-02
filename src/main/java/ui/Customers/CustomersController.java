package ui.Customers;

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
import ui.addNewCustomer.AddNewCustomerController;
import utils.ClientManager;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersController {
    @FXML
    private Button add;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<ClientView> customersTableView;

    @FXML
    private TableColumn<ClientView, String> name;

    @FXML
    private TableColumn<ClientView, String> surname;

    @FXML
    private TableColumn<ClientView, String> email;

    public CustomersController() {

    }

    private List<ClientView> mapClientsToViewModel() {
        return ClientManager
                .getInstance()
                .getClients()
                .stream().map(ClientView::new)
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
        customersTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
        System.out.println(mapClientsToViewModel().size());
    }

    @FXML
    private void addCustomer() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addNewCustomer.fxml"));
        BorderPane page = null;
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        ((AddNewCustomerController)loader.getController()).setDialogStage(dialogStage);
        dialogStage.setTitle("Edit transaction");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(stage);
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
        customersTableView.setItems(FXCollections.observableList(mapClientsToViewModel()));
    }
}
