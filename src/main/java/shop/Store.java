package shop;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct (Product product) {

    }

    public List<Product> getProducts() {
        return products;
    }
}
