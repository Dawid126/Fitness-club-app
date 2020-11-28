import enums.Role;
import enums.WeekDay;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import org.checkerframework.checker.units.qual.A;
import org.hibernate.SessionFactory;
import persistance.DataManager;
import persistance.IDataManager;
import utils.ActivityManager;

import java.lang.module.Configuration;
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
        backTesting();
        Application.launch(args);
    }

    private static void backTesting() {
        IDataManager dataManager = new DataManager();
        DataInitiator initiator = new DataInitiator(dataManager);
        initiator.fillData();
        List<Client> clients = dataManager.loadClients();
        for(Client c : clients) {
            System.out.println(c.getEmail());
        }
        ActivityManager activityManager = new ActivityManager(dataManager);
        for(Activity a : activityManager.getAllActivities(WeekDay.MONDAY)) {
            System.out.println(a.getName());
        }
        List<Host> hosts = dataManager.loadHosts();
//        for(Host host : hosts) {
//            System.out.println(host.getEmail());
//            for(Activity ac : host.getActivities()) {
//                System.out.println(ac.getName());
//            }
//        }
        System.out.println("Activity Manager TEST");
        List<Room> rooms = dataManager.loadRooms();
        DateFormat format = new SimpleDateFormat("hh:mm");
        try {
            if(activityManager.createActivity("xD7",hosts.get(0),rooms.get(0),format.parse("11:30"),format.parse("13:00"), WeekDay.MONDAY))
                System.out.println("SUCCESS");
            else
                System.out.println("FAILURE");
        } catch ( ParseException e ) {
            System.out.println("xD");
        }
    }
}
