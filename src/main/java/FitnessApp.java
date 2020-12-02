import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.DataModule;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.DataInitiator;

public class FitnessApp extends Application {
    private Stage primaryStage;
    private DataInitiator dataInitiator;

    private FitnessController appController;

    @Override
    public void start(Stage primaryStage) {
        Injector injector = Guice.createInjector(new DataModule());
        dataInitiator = injector.getInstance(DataInitiator.class);
        dataInitiator.setManagers(injector);
        dataInitiator.fillData();

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Fitness");

        this.appController = new FitnessController(primaryStage);
        this.appController.initRootLayout();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
