package persistance;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.User;

import java.util.List;

public interface IDataManager {
    void saveActivities(List<Activity> teachers);
    List<Activity> loadActivities();
    void saveClients(List<Client> classes);
    List<Client> loadClients();
    List<Room> loadRooms();
    void saveUsers(List<User> users);
    void saveUser(User user);
    List<User> loadUser();
    User getUserByEmail(String email);
}
