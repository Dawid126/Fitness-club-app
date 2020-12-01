package shop;

import com.sun.scenario.effect.impl.prism.PrReflectionPeer;
import persistance.IDataManager;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final IDataManager dataManager;

    public Store(IDataManager dataManager) {
        this.dataManager = dataManager;
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
