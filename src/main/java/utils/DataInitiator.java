package utils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import enums.Role;
import enums.WeekDay;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import persistence.IDataManager;
import shop.Product;
import shop.Store;

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
            rooms.add(new Room(30,i+1));
        dataManager.saveRooms(rooms);

        users.add(new User("Lukasz","Pitrus","pitrus.to@poczta.com", Role.ADMIN,"aa"));
        dataManager.saveUsers(users);

        hosts.add(new Host("Grzegorz","Gackowski","ggackowski@poczta.com"));
        hosts.add(new Host("Grzegorz2","Gackowski2","ggackowski2@poczta.com"));
        dataManager.saveHosts(hosts);

        clients.add(new Client("Dawid","Bialka","dbialka@poczta.com"));
        clients.add(new Client("Dawid1","Bialka1","dbialka1@poczta.com"));
        clients.add(new Client("Dawid2","Bialka2","dbialka2@poczta.com"));
        clients.add(new Client("Dawid3","Bialka3","dbialka3@poczta.com"));
        clients.add(new Client("Krzysztof","Retkiewicz","kret@poczta.com"));
        clients.add(new Client("Krzysztof1","Retkiewicz1","kret1@poczta.com"));
        clients.add(new Client("Krzysztof2","Retkiewicz2","kret2@poczta.com"));
        clients.add(new Client("Krzysztof3","Retkiewicz3","kret3@poczta.com"));
        dataManager.saveClients(clients);

        try {
            activities.add(new Activity("xD1",hosts.get(0),rooms.get(0),format.parse("10:30"),format.parse("13:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD2",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD3",hosts.get(0),rooms.get(3),format.parse("14:30"),format.parse("16:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD4",hosts.get(1),rooms.get(1),format.parse("14:30"),format.parse("16:00"), WeekDay.MONDAY, 10));
            activities.add(new Activity("xD5",hosts.get(0),rooms.get(4),format.parse("10:30"),format.parse("13:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD6",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD7",hosts.get(0),rooms.get(3),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD8",hosts.get(1),rooms.get(1),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY, 10));
            activities.add(new Activity("xD9",hosts.get(0),rooms.get(4),format.parse("10:30"),format.parse("13:00"), WeekDay.WEDNESDAY, 10));
            activities.add(new Activity("xD10",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("13:00"), WeekDay.WEDNESDAY, 10));
            dataManager.saveActivities(activities);
        } catch ( ParseException e ) {
            e.printStackTrace();
        }

        for(int i=0; i<20; i++) {
            Client c = clients.get(i%clients.size());
            Activity a = activities.get(i%activities.size());
            if(activityManager.addClientToActivity(c,a))
                System.out.println(c.getEmail()+" was added to "+a.getName());
            else
                System.out.println("Adding "+c.getEmail()+" to "+a.getName()+" failed");
        }

//        products.add(new Product("Soczek 1",10,19,"Jakis opis 1"));
//        products.add(new Product("Soczek 2",10,29,"Jakis opis 2"));
//        products.add(new Product("Soczek 3",10,4,"Jakis opis 3"));
//        products.add(new Product("Soczek 4",10,2,"Jakis opis 4"));
//        products.add(new Product("Baton 1",10,21,"Jakis opis 5"));
//        products.add(new Product("Baton 2",10,37,"Jakis opis 6"));
//        products.add(new Product("Baton 3",10,20,"Jakis opis 7"));
//        products.add(new Product("Baton 4",10,30,"Jakis opis 8"));
//        products.add(new Product("Białko 1",10,99,"Jakis opis 9"));
//        products.add(new Product("Białko 2",10,9999,"Jakis opis 10"));
//        products.add(new Product("Białko 3",10,1234,"Jakis opis 11"));
//        products.add(new Product("Białko 4",10,3333,"Jakis opis 12"));

//        dataManager.saveProducts(products);
    }
}
