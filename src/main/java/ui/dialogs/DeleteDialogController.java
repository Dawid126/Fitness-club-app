package ui.dialogs;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import shop.Product;
import utils.ClientManager;
import utils.HostManager;
import utils.RoomManager;

public class DeleteDialogController {

    private Stage dialogStage;

    private Object item;

    public void setSelectedItem(Object item){
        this.item = item;
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
        if(item.getClass().equals(Client.class)) {
            ClientManager manager = ClientManager.getInstance();
            if(manager.removeClient((Client) item)){
                System.out.println("Cannot delete client. There are related items in the system.");
            }
        }else if(item.getClass().equals(Room.class)) {
            RoomManager manager = RoomManager.getInstance();
            if(manager.removeRoom((Room) item)){
                System.out.println("Cannot delete room. There are related items in the system.");
            }
        }else if(item.getClass().equals(Room.class)) {
            HostManager manager = HostManager.getInstance();
            if(manager.removeHost((Host) item)){
                System.out.println("Cannot delete host. There are related items in the system.");
            }
        }
        dialogStage.close();
    }
}
