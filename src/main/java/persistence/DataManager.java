package persistence;

import com.google.inject.Singleton;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import shop.Product;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class DataManager implements IDataManager{

    private List<Client> clients = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Host> hosts = new ArrayList<>();
    private List<Activity> activities = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public DataManager() {}

    @Override
    public void saveActivities(List<Activity> activities) {
        this.activities = activities;
    }
    @Override
    public void saveClients(List<Client> clients) {
        this.clients = clients;
    }
    @Override
    public void saveHosts(List<Host> hosts) {
        this.hosts = hosts;
    }
    @Override
    public void saveUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public void saveRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    @Override
    public void saveProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Activity> loadActivities() {
        return activities;
    }
    @Override
    public List<Client> loadClients() {
        return clients;
    }
    @Override
    public List<Host> loadHosts() {
        return hosts;
    }
    @Override
    public List<User> loadUsers() {
        return users;
    }
    @Override
    public List<Room> loadRooms() {return rooms;}
    @Override
    public List<Product> loadProducts() {
        return products;
    }

    @Override
    public void saveActivity(Activity activity) {
        if(!activities.contains(activity))
            activities.add(activity);
    }
    @Override
    public void saveClient(Client client) {
        if(!clients.contains(client))
            clients.add(client);
    }
    @Override
    public void saveHost(Host host) {
        if(!hosts.contains(host))
            hosts.add(host);
    }
    @Override
    public void saveUser(User user) {
        if(!users.contains(user))
            users.add(user);
    }
    @Override
    public void saveRoom(Room room) {
        if(!rooms.contains(room))
            rooms.add(room);
    }
    @Override
    public void saveProduct(Product product) {
        if(!products.contains(product))
            products.add(product);
    }

    @Override
    public void updateActivity(Activity activity) {

    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void updateHost(Host host) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void updateRoom(Room room) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }
    @Override
    public void removeHost(Host host) {
        hosts.remove(host);
    }
    @Override
    public void removeUser(User user) {
        users.remove(user);
    }
    @Override
    public void removeRoom(Room room) {
        rooms.remove(room);
    }
    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public User getUserByEmail(String email) {
        for(User user: users) {
            if(user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public boolean isEmailFree(String email) {
        for(Client client: clients) {
            if(client.getEmail().equals(email))
                return false;
        }
        for(Host host: hosts) {
            if(host.getEmail().equals(email))
                return false;
        }
        for(User user: users) {
            if(user.getEmail().equals(email))
                return false;
        }
        return true;
    }

}
