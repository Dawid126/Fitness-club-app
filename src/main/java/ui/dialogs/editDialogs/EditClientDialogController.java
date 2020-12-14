package ui.dialogs.editDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.persons.Client;
import utils.ClientManager;

public class EditClientDialogController {
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField email;

    @FXML
    private Text validationError;

    private Stage dialogStage;

    private Client client;

    public void setSelectedClient(Client client){
        this.client = client;
        System.out.println(client);
        name.setText(client.getName());
        surname.setText(client.getSurname());
        email.setText(client.getEmail());
    }

    public EditClientDialogController() {

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
        if (ClientManager.getInstance().updateClient(client, name.getText(), surname.getText(), email.getText())) {
            dialogStage.close();
            return;
        }
        validationError.setVisible(true);
    }
}
