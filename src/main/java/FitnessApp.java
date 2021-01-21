import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.DataModule;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import shop.Store;
import ui.products.productTile.ProductTile;
import utils.DataInitiator;
import utils.LoginManager;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

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

        //TODO LOGIN SCREEN, NOW DEV IS DEFAULT
        //LoginManager.getInstance().login("developer.to@poczta.com", "aa");
        //-------------------------------------

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Fitness");

        this.appController = new FitnessController(primaryStage);
        this.appController.initRootLayout();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }



    public static void main(String[] args){
        Application.launch(args);
    }
}
