package ui.addDialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import utils.ClientManager;
import utils.RoomManager;

public class AddNewRoomController {
    private Stage dialogStage;

    @FXML
    private  Text validationError;

    @FXML
    private TextField capacity;

    @FXML
    private void initialize() {
        validationError.setVisible(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void addRoom(ActionEvent actionEvent) {
        try{
            if (RoomManager.getInstance().createRoom(Integer.parseInt(capacity.getText()))) {
                dialogStage.close();
                return;
            }
            validationError.setVisible(true);
        }catch (java.lang.NumberFormatException e){
            validationError.setVisible(true);
        }
    }
}
