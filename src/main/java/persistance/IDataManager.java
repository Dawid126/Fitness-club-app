package persistance;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;

import java.util.List;

public interface IDataManager {
    void saveActivities(List<Activity> teachers);
    List<Activity> loadActivities();
    void saveClients(List<Client> classes);
    List<Client> loadClients();
    void saveRooms(List<Room> rooms);
    List<Room> loadRooms();
    void saveHosts(List<Host> hosts);
    List<Host> loadHosts();
    void saveUsers(List<User> users);
    void saveUser(User user);
    List<User> loadUsers();
    User getUserByEmail(String email);
}
