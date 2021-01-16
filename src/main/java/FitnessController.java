import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FitnessController {

    private Stage primaryStage;

    public FitnessController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void initRootLayout() {
        try {

            // load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FitnessController.class
                    .getResource("login.fxml"));

            // add layout to a scene and show them all
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            // don't do this in common apps
            e.printStackTrace();
        }

    }
}
