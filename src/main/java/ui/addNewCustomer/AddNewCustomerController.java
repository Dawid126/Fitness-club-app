package ui.addNewCustomer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.ClientManager;

public class AddNewCustomerController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    private Stage dialogStage;

    public AddNewCustomerController() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void addCustomer() {
        System.out.println(ClientManager.getInstance().createClient(name.getText(), surname.getText(), email.getText()));
        System.out.println();
        dialogStage.close();
    }


}
