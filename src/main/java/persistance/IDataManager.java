package persistance;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;

import java.util.List;

public interface IDataManager {
    void saveActivities(List<Activity> activities);
    void saveClients(List<Client> clients);
    void saveHosts(List<Host> hosts);
    void saveUsers(List<User> users);
    void saveRooms(List<Room> rooms);

    List<Activity> loadActivities();
    List<Client> loadClients();
    List<Host> loadHosts();
    List<User> loadUsers();
    List<Room> loadRooms();

    void saveActivity(Activity activity);
    void saveClient(Client client);
    void saveHost(Host host);
    void saveUser(User user);
    void saveRoom(Room room);

    void removeActivity(Activity activity);
    void removeClient(Client client);
    void removeHost(Host host);
    void removeUser(User user);
    void removeRoom(Room room);

    User getUserByEmail(String email);
}
