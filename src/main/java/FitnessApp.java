import enums.WeekDay;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import persistance.DataManager;
import persistance.IDataManager;
import utils.ActivityManager;
import utils.statics.DataInitiator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

    public static void main(String[] args){
        IDataManager dataManager = new DataManager();
        DataInitiator.fillData(dataManager);
        Application.launch(args);
    }
}
