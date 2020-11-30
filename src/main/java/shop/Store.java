package shop;

import persistance.IDataManager;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final IDataManager dataManager;

    public Store(IDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void addProduct (Product product) {
        dataManager.saveProduct(product);
    }

    public List<Product> getProducts() {
        return dataManager.loadProducts();
    }
}
