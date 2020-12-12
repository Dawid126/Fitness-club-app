package utils.statics;

import enums.WeekDay;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import persistence.IDataManager;
import utils.ActivityManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class BackendTester {

    public static void backTesting(IDataManager dataManager) {
        List<Client> clients = dataManager.loadClients();
        for(Client c : clients) {
            System.out.println(c.getEmail());
        }
        ActivityManager activityManager = new ActivityManager(dataManager);
        for(Activity a : activityManager.getActivities(WeekDay.MONDAY)) {
            System.out.println(a.getName());
        }
        List<Host> hosts = dataManager.loadHosts();
        for(Host host : hosts) {
            System.out.println(host.getEmail());
            for(Activity ac : host.getActivities()) {
                System.out.println(ac.getName());
            }
        }
        System.out.println("Activity Manager TEST");
        List<Room> rooms = dataManager.loadRooms();
        DateFormat format = new SimpleDateFormat("hh:mm");
        try {
            if(activityManager.createActivity("xD11",hosts.get(0),rooms.get(0),format.parse("11:30"),format.parse("13:00"), WeekDay.MONDAY, 20))
                System.out.println("SUCCESS");
            else
                System.out.println("FAILURE");
        } catch ( ParseException e ) {
            System.out.println("xD");
        }
    }
}
