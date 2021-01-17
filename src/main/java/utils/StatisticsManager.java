package utils;

import com.google.inject.Inject;
import model.Activity;
import model.persons.Client;
import model.persons.Host;
import persistence.IDataManager;
import shop.Order;
import shop.Product;

import java.util.List;

public class StatisticsManager {

    private final IDataManager dataManager;
    private static StatisticsManager instance;

    public static StatisticsManager getInstance() {
        return instance;
    }

    private Activity topActivity;
    private Client topClient;
    private Host topHost;
    private Order topOrder;
    private Product topProduct;

    @Inject
    public StatisticsManager (IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
        updateTOPs();
    }

    public Activity getTopActivity() {
        updateActivity();
        return topActivity;
    }
    public Client getTopClient() {
        updateClient();
        return topClient;
    }
    public Host getTopHost() {
        updateHost();
        return topHost;
    }
    public Order getTopOrder() {
        updateOrderAndProduct();
        return topOrder;
    }
    public Product getTopProduct() {
        updateOrderAndProduct();
        return topProduct;
    }

    private void updateTOPs() {
        updateActivity();
        updateClient();
        updateHost();
        updateOrderAndProduct();
    }

    private void updateClient() {
        int bestSize = -1;
        List<Client> clients = dataManager.loadClients();
        for(Client c : clients) {
            int activitiesNumber = c.getActivities().size();
            if(bestSize < activitiesNumber) {
                bestSize = activitiesNumber;
                topClient = c;
            }
        }
    }

    private void updateHost() {
        int bestSize = -1;
        List<Host> hosts = dataManager.loadHosts();
        for(Host h : hosts) {
            int activitiesNumber = h.getActivities().size();
            if(bestSize < activitiesNumber) {
                bestSize = activitiesNumber;
                topHost = h;
            }
        }
    }

    private void updateActivity() {
        int bestSize = -1;
        List<Activity> activities = dataManager.loadActivities();
        for(Activity a : activities) {
            int clientsNumber = a.getParticipants().size();
            if(bestSize < clientsNumber) {
                bestSize = clientsNumber;
                topActivity = a;
            }
        }
    }

    private void updateOrderAndProduct() {
        int bestPrice = -1;
        List<Order> orders = dataManager.loadOrders();
        for(Order o : orders) {
            if(o.getStatus().equals(Order.Status.SEND)) {
                int price = o.getQuantity() * o.getProduct().getPrice();
                if(bestPrice < price) {
                    bestPrice = price;
                    topOrder = o;
                    topProduct = o.getProduct();
                }
            }
        }
    }
}
