package ui.dialogs.editDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.persons.Client;
import model.persons.Host;
import utils.ClientManager;
import utils.HostManager;

public class EditHostDialogController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private Text validationError;

    private Stage dialogStage;

    private Host host;

    public void setSelectedHost(Host host){
        this.host = host;
        name.setText(host.getName());
        surname.setText(host.getSurname());
        email.setText(host.getEmail());
    }

    public EditHostDialogController() {

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
        if (HostManager.getInstance().updateHost(host, name.getText(), surname.getText(), email.getText())) {
            dialogStage.close();
            return;
        }
        validationError.setVisible(true);
    }
}
