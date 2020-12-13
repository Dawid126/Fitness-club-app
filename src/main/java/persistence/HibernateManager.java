package persistence;

import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.session.SessionService;
import shop.Product;

import java.util.List;

public class HibernateManager implements IDataManager {
    @Override
    public void saveActivities(List<Activity> activities) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Activity activity : activities) {
            session.save(activity);
            session.merge(activity);
        }
        tx.commit();
    }

    @Override
    public void saveClients(List<Client> clients) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Client client : clients) {
            session.save(client);
            session.merge(client);
        }
        tx.commit();
    }

    @Override
    public void saveHosts(List<Host> hosts) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Host host : hosts) {
            session.save(host);
            session.merge(host);
        }
        tx.commit();
    }

    @Override
    public void saveUsers(List<User> users) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(User user : users) {
            session.save(user);
            session.merge(user);
        }
        tx.commit();
    }

    @Override
    public void saveRooms(List<Room> rooms) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Room room : rooms) {
            session.save(room);
            session.merge(room);
        }
        tx.commit();
    }

    @Override
    public void saveProducts(List<Product> Product) {

    }

    @Override
    public List<Activity> loadActivities() {
        return null;
    }

    @Override
    public List<Client> loadClients() {
        return null;
    }

    @Override
    public List<Host> loadHosts() {
        return null;
    }

    @Override
    public List<User> loadUsers() {
        return null;
    }

    @Override
    public List<Room> loadRooms() {
        return null;
    }

    @Override
    public List<Product> loadProducts() {
        return null;
    }

    @Override
    public void saveActivity(Activity activity) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(activity);
        session.merge(activity);
        tx.commit();
    }

    @Override
    public void saveClient(Client client) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(client);
        session.merge(client);
        tx.commit();
    }

    @Override
    public void saveHost(Host host) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(host);
        session.merge(host);
        tx.commit();
    }

    @Override
    public void saveUser(User user) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(user);
        session.merge(user);
        tx.commit();
    }

    @Override
    public void saveRoom(Room room) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(room);
        session.merge(room);
        tx.commit();
    }

    @Override
    public void saveProduct(Product product) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(product);
        session.merge(product);
        tx.commit();
    }

    @Override
    public void updateActivity(Activity activity) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(activity);
        session.merge(activity);
        tx.commit();
    }

    @Override
    public void updateClient(Client client) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(client);
        session.merge(client);
        tx.commit();
    }

    @Override
    public void updateHost(Host host) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(host);
        session.merge(host);
        tx.commit();
    }

    @Override
    public void updateUser(User user) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(user);
        session.merge(user);
        tx.commit();
    }

    @Override
    public void updateRoom(Room room) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(room);
        session.merge(room);
        tx.commit();
    }

    @Override
    public void updateProduct(Product product) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(product);
        session.merge(product);
        tx.commit();
    }

    @Override
    public void removeActivity(Activity activity) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(activity);
        tx.commit();
    }

    @Override
    public void removeClient(Client client) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(client);
        tx.commit();
    }

    @Override
    public void removeHost(Host host) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(host);
        tx.commit();
    }

    @Override
    public void removeUser(User user) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }

    @Override
    public void removeRoom(Room room) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(room);
        tx.commit();
    }

    @Override
    public void removeProduct(Product product) {
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public boolean isEmailFree(String email) {
        return false;
    }
}
