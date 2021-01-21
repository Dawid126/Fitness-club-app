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
import shop.Order;
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
    private StatisticsManager statisticsManager;

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
        this.statisticsManager = injector.getInstance(StatisticsManager.class);
    }

    public void fillData () {
//        initData();
//        manyToManyConnections();
    }

    private void initData () {
        DateFormat format = new SimpleDateFormat("hh:mm");

        List<Room> rooms = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Host> hosts = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        for(int i=0; i<5; i++)
            rooms.add(new Room(30,i+1));
        dataManager.saveRooms(rooms);

        users.add(new User("Lukasz","Pitrus","pitrus.to@poczta.com", Role.ADMIN,"aa"));
        users.add(new User("Admin","Admin","admin.to@poczta.com", Role.ADMIN,"aa"));
        users.add(new User("Manager","Manager","enroller.to@poczta.com", Role.MANAGER,"aa"));
        users.add(new User("Developer","Developer","dev@dev.com", Role.DEVELOPER,"aa"));
        users.add(new User("Receptionist","Receptionist","receptionist.to@poczta.com", Role.RECEPTIONIST,"aa"));

        dataManager.saveUsers(users);

        hosts.add(new Host("Grzegorz","Gackowski","ggackowski@poczta.com"));
        hosts.add(new Host("Grzegorza","Gackowskia","ggackowski2@poczta.com"));
        dataManager.saveHosts(hosts);

        clients.add(new Client("Dawid","Bialka","dbialka@poczta.com"));
        clients.add(new Client("Dawida","Bialkaa","dbialka1@poczta.com"));
        clients.add(new Client("Dawidb","Bialkab","dbialka2@poczta.com"));
        clients.add(new Client("Dawidc","Bialkac","dbialka3@poczta.com"));
        clients.add(new Client("Krzysztof","Retkiewicz","kret@poczta.com"));
        clients.add(new Client("Krzysztofa","Retkiewicza","kret1@poczta.com"));
        clients.add(new Client("Krzysztofb","Retkiewiczb","kret2@poczta.com"));
        clients.add(new Client("Krzysztofc","Retkiewiczc","kret3@poczta.com"));
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

        products.add(new Product("Soczek 1",10,19,"Jakis opis 1"));
        products.add(new Product("Soczek 2",10,29,"Jakis opis 2"));
        products.add(new Product("Soczek 3",10,4,"Jakis opis 3"));
        products.add(new Product("Soczek 4",10,2,"Jakis opis 4"));
        products.add(new Product("Baton 1",10,21,"Jakis opis 5"));
        products.add(new Product("Baton 2",10,37,"Jakis opis 6"));
        products.add(new Product("Baton 3",10,20,"Jakis opis 7"));
        products.add(new Product("Baton 4",10,30,"Jakis opis 8"));
        products.add(new Product("Bialko 1",10,99,"Jakis opis 9"));
        products.add(new Product("Bialko 2",10,9999,"Jakis opis 10"));
        products.add(new Product("Bialko 3",10,1234,"Jakis opis 11"));
        products.add(new Product("Bialko 4",10,3333,"Jakis opis 12"));

        dataManager.saveProducts(products);

        orders.add(new Order(clients.get(0), products.get(0), 4));
        orders.get(0).statusChange(Order.Status.SEND);
        orders.add(new Order(clients.get(1), products.get(1), 7));
        orders.get(1).statusChange(Order.Status.SEND);
        orders.add(new Order(clients.get(2), products.get(0), 3));
        orders.get(2).statusChange(Order.Status.SEND);
        orders.add(new Order(clients.get(3), products.get(7), 10));
        orders.get(3).statusChange(Order.Status.SEND);
        orders.add(new Order(clients.get(4), products.get(10), 2));
        orders.get(4).statusChange(Order.Status.SEND);

        dataManager.saveOrders(orders);
    }

    private void manyToManyConnections() {
        List<Client> clients = dataManager.loadClients();
        List<Activity> activities = dataManager.loadActivities();
        for(int i=0; i<20; i++) {
            Client c = clients.get(i%clients.size());
            Activity a = activities.get(i%activities.size());
            if(!activityManager.addClientToActivity(c,a))
                System.out.println("Adding "+c.getEmail()+" to "+a.getName()+" failed");
        }
    }
}
