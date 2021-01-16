package ui;

import enums.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import utils.LoginManager;

import java.io.IOException;
import java.net.URL;

public class MainMenuController {

    @FXML
    private BorderPane routerContainer;

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab gymTab;
    @FXML
    private Tab storeTab;
    @FXML
    private Tab adminTab;

    @FXML
    private VBox productTabButtons;
    @FXML
    private Button addNewProductButtton;

    @FXML
    private void initialize(){
        Role role = LoginManager.getInstance().getLoggedUser().getRole();

        switch (role){
            case MANAGER -> {
                tabPane.getTabs().remove(adminTab);
            }
            case RECEPTIONIST -> {
                tabPane.getTabs().remove(adminTab);
                productTabButtons.getChildren().remove(addNewProductButtton);
            }
            case ADMIN -> {
                productTabButtons.getChildren().remove(addNewProductButtton);
            }
        }
    }

    @FXML
    private void handleShowView(ActionEvent e) {
        String view = (String) ((Node) e.getSource()).getUserData();
        System.out.println(view);
        loadFXML(getClass().getResource(view));
    }

    private void loadFXML(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            routerContainer.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
