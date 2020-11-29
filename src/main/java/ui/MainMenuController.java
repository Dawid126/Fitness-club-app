package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class MainMenuController {

    @FXML
    private BorderPane routerContainer;

    @FXML
    private void handleShowView(ActionEvent e) {
        String view = (String) ((Node) e.getSource()).getUserData();
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
