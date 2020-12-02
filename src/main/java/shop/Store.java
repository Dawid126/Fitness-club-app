package shop;

import com.google.inject.Inject;
import persistance.IDataManager;

import java.util.List;

public class Store {
    private final IDataManager dataManager;
    private static Store instance = null;

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
        dataManager.removeProduct(product);
        return true;
    }

    public static Store getInstance() {
        return instance;
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
}
