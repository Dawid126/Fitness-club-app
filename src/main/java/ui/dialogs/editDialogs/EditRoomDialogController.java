package ui.dialogs.editDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Room;
import model.persons.Client;
import utils.ClientManager;
import utils.RoomManager;

public class EditRoomDialogController {

    @FXML
    private TextField capacity;

    @FXML
    private Text validationError;

    private Stage dialogStage;

    private Room room;

    public void setSelectedRoom(Room room){
        this.room = room;
        capacity.setText(String.valueOf(room.getCapacity()));
    }

    public EditRoomDialogController() {

    }

    @FXML
    private void initialize() {
        validationError.setVisible(false);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void saveRoom() {
        if (RoomManager.getInstance().updateRoom(room, Integer.parseInt(capacity.getText()))) {
            dialogStage.close();
            return;
        }
        validationError.setVisible(true);
    }
}
