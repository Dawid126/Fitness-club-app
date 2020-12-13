package ui.dialogs;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.persons.Client;
import utils.ClientManager;

public class DeleteDialogController {

    private Stage dialogStage;

    private Client client;

    public void setSelectedClient(Client client){
        this.client = client;
    }

    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void cancel(){
        dialogStage.close();
    }

    @FXML
    private void delete(){
        ClientManager clientManager = ClientManager.getInstance();
        clientManager.removeClient(client);
        dialogStage.close();
    }
}
