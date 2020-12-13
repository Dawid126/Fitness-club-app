package ui.dialogs.addDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ClientManager;

public class AddNewClientController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private Text validationError;

    private Stage dialogStage;

    public AddNewClientController() {

    }

    @FXML
    private void initialize() {
        validationError.setVisible(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void addCustomer() {
        if (ClientManager.getInstance().createClient(name.getText(), surname.getText(), email.getText())) {
            dialogStage.close();
            return;
        }
        validationError.setVisible(true);
    }


}
