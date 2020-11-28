package persistance;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;

import java.util.ArrayList;
import java.util.List;

public class DataManager implements IDataManager{

    private List<Client> clients = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Host> hosts = new ArrayList<>();
    private List<Activity> activities = new ArrayList<>(); //to be deleted

    public DataManager() {}

    @Override
    public void saveActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public List<Activity> loadActivities() {
        return activities;
    }

    @Override
    public void saveClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public List<Client> loadClients() {
        return clients;
    }

    @Override
    public void saveRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public List<Room> loadRooms() {return rooms;}

    @Override
    public void saveHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    @Override
    public List<Host> loadHosts() {
        return hosts;
    }

    @Override
    public void saveUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> loadUsers() {
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        for(User user: users) {
            if(user.getEmail().equals(email)) return user;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
