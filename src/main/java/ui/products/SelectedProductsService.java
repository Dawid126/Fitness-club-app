package ui.products;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import shop.Product;

public class SelectedProductsService {
    private BooleanProperty isNoProductSelected = new SimpleBooleanProperty();
    private ObjectProperty<Product> selectedProd = new SimpleObjectProperty<>();
    private ProductsController subscriber;

    public SelectedProductsService(ProductsController subscriber) {
        this.subscriber = subscriber;
        selectedProd.setValue(null);
        isNoProductSelected.setValue(true);
    }

    public void setSelectedProduct(Product product) {
        selectedProd.setValue(product);
        isNoProductSelected.setValue(false);
    }

    public void deleteSelectedProduct(){
        Product productToDelete = selectedProd.getValue();
        selectedProd.setValue(null);
        subscriber.notifyDelete(productToDelete);
    }

    public BooleanProperty isNoProductSelected() {
        return isNoProductSelected;
    }

    public ObjectProperty<Product> getSelectedProduct() {
        return selectedProd;
    }
}
