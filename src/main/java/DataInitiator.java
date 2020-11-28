import enums.Role;
import enums.WeekDay;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import persistance.IDataManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataInitiator {
    private final IDataManager dataManager;

    public DataInitiator (IDataManager dataManager) {
        this.dataManager = dataManager;
    }
    public void fillData () {
        DateFormat format = new SimpleDateFormat("hh:mm");

        List<Room> rooms = new ArrayList<>();
        List<User> users = new ArrayList<>();
        List<Host> hosts = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Activity> activities = new ArrayList<>();

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
            activities.add(new Activity("xD",hosts.get(0),rooms.get(0),format.parse("10:30"),format.parse("12:00"), WeekDay.MONDAY));
            activities.add(new Activity("xD",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("12:00"), WeekDay.MONDAY));
            activities.add(new Activity("xD",hosts.get(0),rooms.get(3),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY));
            activities.add(new Activity("xD",hosts.get(1),rooms.get(1),format.parse("14:30"),format.parse("16:00"), WeekDay.TUESDAY));
            activities.add(new Activity("xD",hosts.get(0),rooms.get(4),format.parse("10:30"),format.parse("12:00"), WeekDay.WEDNESDAY));
            activities.add(new Activity("xD",hosts.get(1),rooms.get(2),format.parse("10:30"),format.parse("12:00"), WeekDay.WEDNESDAY));
        } catch ( ParseException e ) {
            System.out.println("xD");
        }

        dataManager.saveRooms(rooms);
        dataManager.saveUsers(users);
        dataManager.saveHosts(hosts);
        dataManager.saveActivities(activities);
        dataManager.saveClients(clients);
    }
}
