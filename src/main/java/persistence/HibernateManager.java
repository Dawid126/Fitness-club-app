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
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Activity activity : activities) {
            session.save(activity);
            session.merge(activity);
        }
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveClients(List<Client> clients) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Client client : clients) {
            session.save(client);
            session.merge(client);
        }
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveHosts(List<Host> hosts) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Host host : hosts) {
            session.save(host);
            session.merge(host);
        }
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveUsers(List<User> users) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(User user : users) {
            session.save(user);
            session.merge(user);
        }
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveRooms(List<Room> rooms) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Room room : rooms) {
            session.save(room);
            session.merge(room);
        }
        tx.commit();
        SessionService.closeSession();
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
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(activity);
        session.merge(activity);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveClient(Client client) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(client);
        session.merge(client);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveHost(Host host) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(host);
        session.merge(host);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveUser(User user) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(user);
        session.merge(user);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveRoom(Room room) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(room);
        session.merge(room);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void saveProduct(Product product) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.save(product);
        session.merge(product);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateActivity(Activity activity) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(activity);
        session.merge(activity);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateClient(Client client) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(client);
        session.merge(client);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateHost(Host host) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(host);
        session.merge(host);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateUser(User user) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(user);
        session.merge(user);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateRoom(Room room) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(room);
        session.merge(room);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void updateProduct(Product product) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.update(product);
        session.merge(product);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeActivity(Activity activity) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(activity);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeClient(Client client) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(client);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeHost(Host host) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(host);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeUser(User user) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeRoom(Room room) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(room);
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public void removeProduct(Product product) {
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
        SessionService.closeSession();
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
