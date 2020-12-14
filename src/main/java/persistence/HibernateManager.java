package persistence;

import com.google.inject.Singleton;
import model.Activity;
import model.Room;
import model.persons.Client;
import model.persons.Host;
import model.persons.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.session.SessionService;
import shop.Product;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class HibernateManager implements IDataManager {

    private List<Client> clients;
    private List<User> users;
    private List<Room> rooms;
    private List<Host> hosts;
    private List<Activity> activities;
    private List<Product> products;

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
        SessionService.openSession();
        final Session session = SessionService.getSession();
        final Transaction tx = session.beginTransaction();
        for(Product product : products) {
            session.save(product);
            session.merge(product);
        }
        tx.commit();
        SessionService.closeSession();
    }

    @Override
    public List<Activity> loadActivities() {
        if(activities == null) {
            SessionService.openSession();
            activities =  SessionService.getSession().createQuery("FROM Activity ", Activity.class).list();
            SessionService.closeSession();
        }
        return activities;
    }

    @Override
    public List<Client> loadClients() {
        if(clients == null) {
            SessionService.openSession();
            clients =  SessionService.getSession().createQuery("FROM Client", Client.class).list();
            SessionService.closeSession();
        }
        return clients;
    }

    @Override
    public List<Host> loadHosts() {
        if(hosts == null) {
            SessionService.openSession();
            hosts =  SessionService.getSession().createQuery("FROM Host ", Host.class).list();
            SessionService.closeSession();
        }
        return hosts;
    }

    @Override
    public List<User> loadUsers() {
        if(users == null) {
            SessionService.openSession();
            users =  SessionService.getSession().createQuery("FROM User ", User.class).list();
            SessionService.closeSession();
        }
        return users;
    }

    @Override
    public List<Room> loadRooms() {
        if(rooms == null) {
            SessionService.openSession();
            rooms =  SessionService.getSession().createQuery("FROM Room ", Room.class).list();
            SessionService.closeSession();
        }
        return rooms;
    }

    @Override
    public List<Product> loadProducts() {
        if(products == null) {
            SessionService.openSession();
            products =  SessionService.getSession().createQuery("FROM Product ", Product.class).list();
            SessionService.closeSession();
        }
        return products;
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
