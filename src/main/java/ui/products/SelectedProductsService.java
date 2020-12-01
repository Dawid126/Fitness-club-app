package ui.products;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableBooleanValue;
import shop.Product;

public class SelectedProductsService {
    private Product selectedProduct;
    private BooleanProperty isNoProductSelected = new SimpleBooleanProperty();
    private ObjectProperty<Product> selectedProd = new SimpleObjectProperty<>();

    public SelectedProductsService() {
        selectedProd.setValue(null);
        selectedProduct = null;
        isNoProductSelected.setValue(true);
    }

    public void setSelectedProduct(Product product) {
        selectedProduct = product;
        selectedProd.setValue(product);
        isNoProductSelected.setValue(false);
    }

    public BooleanProperty isNoProductSelected() {
        return isNoProductSelected;
    }

    public ObjectProperty<Product> getSelectedProduct() {
        return selectedProd;
    }
}
