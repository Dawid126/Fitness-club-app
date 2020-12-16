package ui.dialogs.addDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ClientManager;
import utils.HostManager;

public class AddNewHostController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private Text validationError;

    private Stage dialogStage;

    public AddNewHostController() {

    }

    @FXML
    private void initialize() {
        validationError.setVisible(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void addHost() {
        if (HostManager.getInstance().createHost(name.getText(), surname.getText(), email.getText())) {
            dialogStage.close();
            return;
        }
        validationError.setVisible(true);
    }


}
