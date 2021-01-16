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
import shop.Order;
import shop.Product;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
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
    private List<Order> orders;

    private boolean clientsChange = true;
    private boolean usersChange = true;
    private boolean roomsChange = true;
    private boolean hostsChange = true;
    private boolean activitiesChange = true;
    private boolean productsChange = true;
    private boolean ordersChange = true;

    @Override
    public void saveActivities(List<Activity> activities) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Activity activity : activities) {
                session.save(activity);
                session.merge(activity);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveClients(List<Client> clients) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Client client : clients) {
                session.save(client);
                session.merge(client);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveHosts(List<Host> hosts) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Host host : hosts) {
                session.save(host);
                session.merge(host);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUsers(List<User> users) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(User user : users) {
                session.save(user);
                session.merge(user);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveRooms(List<Room> rooms) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Room room : rooms) {
                session.save(room);
                session.merge(room);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveProducts(List<Product> products) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Product product : products) {
                session.save(product);
                session.merge(product);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveOrders(List<Order> orders) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            for(Order order : orders) {
                session.save(order);
                session.merge(order);
            }
            tx.commit();
            SessionService.closeSession();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Activity> loadActivities() {
        try {
            if(activitiesChange) {
                SessionService.openSession();
                activities =  SessionService.getSession().createQuery("FROM Activity ", Activity.class).list();
                SessionService.closeSession();
                activitiesChange = !activitiesChange;
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return activities;
    }

    @Override
    public List<Client> loadClients() {
        try {
            if(clientsChange) {
                SessionService.openSession();
                clients =  SessionService.getSession().createQuery("FROM Client", Client.class).list();
                SessionService.closeSession();
                clientsChange = !clientsChange;
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public List<Host> loadHosts() {
        try {
            if(hostsChange) {
                SessionService.openSession();
                hosts =  SessionService.getSession().createQuery("FROM Host ", Host.class).list();
                SessionService.closeSession();
                hostsChange = !hostsChange;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return hosts;
    }

    @Override
    public List<User> loadUsers() {
        try {
            if(usersChange) {
                SessionService.openSession();
                users =  SessionService.getSession().createQuery("FROM User ", User.class).list();
                SessionService.closeSession();
                usersChange = !usersChange;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<Room> loadRooms() {
        try {
            if(roomsChange) {
                SessionService.openSession();
                rooms =  SessionService.getSession().createQuery("FROM Room ", Room.class).list();
                SessionService.closeSession();
                roomsChange = !roomsChange;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public List<Product> loadProducts() {
        try {
            if(productsChange) {
                SessionService.openSession();
                products =  SessionService.getSession().createQuery("FROM Product ", Product.class).list();
                SessionService.closeSession();
                productsChange = !productsChange;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Order> loadOrders() {
        try {
            if(ordersChange) {
                SessionService.openSession();
                orders =  SessionService.getSession().createQuery("FROM Order ", Order.class).list();
                SessionService.closeSession();
                ordersChange = !ordersChange;
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void saveActivity(Activity activity) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(activity);
            session.merge(activity);
            tx.commit();
            SessionService.closeSession();
            activitiesChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveClient(Client client) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(client);
            session.merge(client);
            tx.commit();
            SessionService.closeSession();
            clientsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveHost(Host host) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(host);
            session.merge(host);
            tx.commit();
            SessionService.closeSession();
            hostsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(User user) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(user);
            session.merge(user);
            tx.commit();
            SessionService.closeSession();
            usersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRoom(Room room) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(room);
            session.merge(room);
            tx.commit();
            SessionService.closeSession();
            roomsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveProduct(Product product) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(product);
            session.merge(product);
            tx.commit();
            SessionService.closeSession();
            productsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrder(Order order) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.save(order);
            session.merge(order);
            tx.commit();
            SessionService.closeSession();
            ordersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateActivity(Activity activity) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(activity);
            session.merge(activity);
            tx.commit();
            SessionService.closeSession();
            activitiesChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateClient(Client client) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(client);
            session.merge(client);
            tx.commit();
            SessionService.closeSession();
            clientsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateHost(Host host) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(host);
            session.merge(host);
            tx.commit();
            SessionService.closeSession();
            hostsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(User user) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(user);
            session.merge(user);
            tx.commit();
            SessionService.closeSession();
            usersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateRoom(Room room) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(room);
            session.merge(room);
            tx.commit();
            SessionService.closeSession();
            roomsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(Product product) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(product);
            session.merge(product);
            tx.commit();
            SessionService.closeSession();
            productsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateOrder(Order order) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.update(order);
            session.merge(order);
            tx.commit();
            SessionService.closeSession();
            ordersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeActivity(Activity activity) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(activity);
            tx.commit();
            SessionService.closeSession();
            activitiesChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeClient(Client client) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(client);
            tx.commit();
            SessionService.closeSession();
            clientsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeHost(Host host) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(host);
            tx.commit();
            SessionService.closeSession();
            hostsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUser(User user) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
            SessionService.closeSession();
            usersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeRoom(Room room) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(room);
            tx.commit();
            SessionService.closeSession();
            roomsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeProduct(Product product) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(product);
            tx.commit();
            SessionService.closeSession();
            productsChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeOrder(Order order) {
        try {
            SessionService.openSession();
            final Session session = SessionService.getSession();
            final Transaction tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
            SessionService.closeSession();
            ordersChange = true;
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByEmail(String email) {
        User user;
        try {
            SessionService.openSession();
            user = SessionService.getSession()
                    .createQuery("SELECT c FROM User c WHERE c.email = :email", User.class)
                    .setParameter("email", email).getSingleResult();
            SessionService.closeSession();
        }
        catch (NoResultException e) {
            return null;
        }
        return user;
    }

    @Override
    public boolean isEmailFree(String email) {
        List users;
        List clients;
        List hosts;

        try {
            SessionService.openSession();
            users = SessionService.getSession()
                    .createQuery("SELECT u.email FROM User u WHERE u.email = :email")
                    .setParameter("email", email).getResultList();

            if(!users.isEmpty()) return false;

            clients = SessionService.getSession()
                    .createQuery("SELECT c.email FROM Client c WHERE c.email = :email")
                    .setParameter("email", email).getResultList();

            if(!clients.isEmpty()) return false;

            hosts = SessionService.getSession()
                    .createQuery("SELECT h.email FROM Host h WHERE h.email = :email")
                    .setParameter("email", email).getResultList();

            SessionService.closeSession();

            return (hosts.isEmpty());
        }
        catch (PersistenceException e) {
            e.printStackTrace();
        }

        return false;
    }
}
