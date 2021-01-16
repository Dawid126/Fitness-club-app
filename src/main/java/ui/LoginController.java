package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.LoginManager;

import java.io.IOException;

public class LoginController {
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Text error;

    @FXML
    private AnchorPane pane;

    public LoginController() {

    }

    public void initialize() {
        error.setVisible(false);
    }

    public void logInUser() {
        var loginManager = LoginManager.getInstance();
        System.out.println(emailField.getText());
        System.out.println(passwordField.getText());
        if (!loginManager.login(emailField.getText(), passwordField.getText())) {
            error.setVisible(true);
            return;
        }
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass()
                .getResource("/mainMenu.fxml"));

        // add layout to a scene and show them all
        try {
            Scene scene = new Scene(loader.load());
            ((Stage)pane.getScene().getWindow()).setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
