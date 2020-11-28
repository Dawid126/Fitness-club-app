import javafx.application.Application;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

import java.lang.module.Configuration;

public class FitnessApp extends Application {
    private Stage primaryStage;

    private FitnessController appController;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Fitness");

        this.appController = new FitnessController(primaryStage);
        this.appController.initRootLayout();
    }

    public static void main(String args[]){
        Application.launch(args);
    }
}
