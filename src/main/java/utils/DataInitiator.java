package utils;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import enums.Role;
import enums.WeekDay;
import guice.DataModule;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import persistance.IDataManager;
import shop.Product;
import shop.Store;
import utils.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataInitiator {

    private final IDataManager dataManager;
    private Store store;
    private ActivityManager activityManager;
    private ClientManager clientManager;
    private HostManager hostManager;
    private LoginManager loginManager;
    private RoomManager roomManager;
    private UserManager userManager;

    @Inject
    public DataInitiator(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setManagers(Injector injector) {
        this.store = injector.getInstance(Store.class);
        this.activityManager = injector.getInstance(ActivityManager.class);
        this.clientManager = injector.getInstance(ClientManager.class);
        this.hostManager = injector.getInstance(HostManager.class);
        this.loginManager = injector.getInstance(LoginManager.class);
        this.roomManager = injector.getInstance(RoomManager.class);
        this.userManager = injector.getInstance(UserManager.class);
    }

    public void fillData () {
        DateFormat format = new SimpleDateFormat("hh:mm");

        List<Room> rooms = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Host> hosts = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        for(int i=0; i<5; i++)
            rooms.add(new Room(30));

        users.add(new User("Lukasz","Pitrus","kret.to@xd.com", Role.ADMIN,"xd"));

        hosts.add(new Host("Grzegorz","Gackowski","ggackowski@xd.com"));
        hosts.add(new Host("Grzegorz2","Gackowski2","ggackowski2@xd.com"));

        clients.add(new Client("Dawid","Bialka","dbialka@xd.com"));
        clients.add(new Client("Dawid1","Bialka1","dbialka1@xd.com"));
        clients.add(new Client("Dawid2","Bialka2","dbialka2@xd.com"));
        clients.add(new Client("Dawid3","Bialka3","dbialka3@xd.com"));
        clients.add(new Client("Krzysztof","Retkiewicz","kret@xd.com"));
        clients.add(new Client("Krzysztof1","Retkiewicz1","kret1@xd.com"));
        clients.add(new Client("Krzysztof2","Retkiewicz2","kret2@xd.com"));
        clients.add(new Client("Krzysztof3","Retkiewicz3","kret3@xd.com"));

        try {
            activities.add(new Activity("xD1",hosts.get(0),rooms.get(0),format.parse("10:30"),format.parse("13:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD2",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD3",hosts.get(0),rooms.get(3),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD4",hosts.get(1),rooms.get(1),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD5",hosts.get(0),rooms.get(4),format.parse("10:30"),format.parse("13:00"), WeekDay.WEDNESDAY, 10));
            activities.add(new Activity("xD6",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.WEDNESDAY, 10));
            activities.add(new Activity("xD7",hosts.get(0),rooms.get(3),format.parse("14:30"),format.parse("16:00"), WeekDay.THURSDAY, 10));
            activities.add(new Activity("xD8",hosts.get(1),rooms.get(1),format.parse("14:30"),format.parse("16:00"), WeekDay.THURSDAY, 10));
            activities.add(new Activity("xD9",hosts.get(0),rooms.get(4),format.parse("10:30"),format.parse("13:00"), WeekDay.FRIDAY, 10));
            activities.add(new Activity("xD10",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.FRIDAY, 10));
        } catch ( ParseException e ) {
            System.out.println("xD");
        }

        products.add(new Product("Soczek dla koxa",10,2137,"Description"));
        products.add(new Product("Soczek dla cziki",10,2137,"Description"));
        products.add(new Product("Soczek dla dzika",10,2137,"Description"));
        products.add(new Product("Soczek dla byczka",10,2137,"Description"));
        products.add(new Product("Baton dla koxa",10,2137,"Description"));
        products.add(new Product("Baton dla cziki",10,2137,"Description"));
        products.add(new Product("Baton dla dzika",10,2137,"Description"));
        products.add(new Product("Baton dla byczka",10,2137,"Description"));
        products.add(new Product("Białko dla koxa",10,2137,"Description"));
        products.add(new Product("Białko dla cziki",10,2137,"Description"));
        products.add(new Product("Białko dla dzika",10,2137,"Description"));
        products.add(new Product("Białko dla byczka",10,2137,"Description"));

        dataManager.saveRooms(rooms);
        dataManager.saveUsers(users);
        dataManager.saveHosts(hosts);
        dataManager.saveActivities(activities);
        dataManager.saveClients(clients);
        dataManager.saveProducts(products);
    }
}
