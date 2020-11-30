package persistance;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import shop.Product;

import java.util.List;

public interface IDataManager {
    void saveActivities(List<Activity> activities);
    void saveClients(List<Client> clients);
    void saveHosts(List<Host> hosts);
    void saveUsers(List<User> users);
    void saveRooms(List<Room> rooms);
    void saveProducts(List<Product> Product);

    List<Activity> loadActivities();
    List<Client> loadClients();
    List<Host> loadHosts();
    List<User> loadUsers();
    List<Room> loadRooms();
    List<Product> loadProducts();

    void saveActivity(Activity activity);
    void saveClient(Client client);
    void saveHost(Host host);
    void saveUser(User user);
    void saveRoom(Room room);
    void saveProduct(Product product);

    void removeActivity(Activity activity);
    void removeClient(Client client);
    void removeHost(Host host);
    void removeUser(User user);
    void removeRoom(Room room);
    void removeProduct(Product product);

    User getUserByEmail(String email);
    boolean isEmailFree(String email);
}
