import javafx.application.Application;
import javafx.stage.Stage;
import persistance.DataManager;
import persistance.IDataManager;
import shop.Store;
import utils.statics.DataInitiator;

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
        new Store(dataManager);
        Application.launch(args);
    }
}
