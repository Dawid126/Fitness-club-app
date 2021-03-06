package shop;

import com.google.inject.Inject;
import model.persons.Client;
import persistence.IDataManager;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Store {
    private final IDataManager dataManager;
    private static Store instance = null;

    public static Store getInstance() {
        return instance;
    }

    @Inject
    public Store(IDataManager dataManager) {
        this.dataManager = dataManager;
        instance = this;
    }

    public boolean createProduct (String name, int quantity, int price, String description) {
        if(getProduct(name) == null) {
            dataManager.saveProduct(new Product(name,quantity,price,description));
            return true;
        }
        return false;
    }

    public boolean removeProduct (Product product) {
        for(Order order : product.getOrders()) {
            removeOrder(order);
        }
        dataManager.removeProduct(product);
        return true;
    }

    public boolean orderProduct (Product product, Client client, int quantity) {
        if(product.setQuantity(product.getQuantity()-quantity))
            return false;
        Order newOrder = new Order(client,product,quantity);
        dataManager.saveOrder(newOrder);
        client.getOrders().add(newOrder);
        product.getOrders().add(newOrder);
        dataManager.updateClient(client);
        dataManager.updateProduct(product);
        return true;
    }

    public void removeOrder (Order order) {
        dataManager.removeOrder(order);
        order.getClient().getOrders().remove(order);
        order.getProduct().setQuantity(order.getProduct().getQuantity() + order.getQuantity());
        order.getProduct().getOrders().remove(order);
        dataManager.updateClient(order.getClient());
        dataManager.updateProduct(order.getProduct());
    }

    public List<Product> getProducts() {
        return dataManager.loadProducts();
    }

    public Product getProduct(String name) {
        List<Product> products = getProducts();
        for(Product product : products) {
            if(product.getName().equals(name))
                return product;
        }
        return null;
    }

    public void setPhoto(Product product, String path) {
        setPhoto(product,new File(path));
    }
    public void setPhoto(Product product, File file) {
        byte[] bFile = new byte[(int) file.length()];

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        product.setImage(bFile);
        dataManager.updateProduct(product);
    }

    public boolean updateProduct(Product product, String name, int quantity, double price, String description) {
        if(getProduct(name) == product||getProduct(name) == null) {
            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            product.setDescription(description);
            dataManager.updateProduct(product);
            return true;
        }
        return false;
    }
}
