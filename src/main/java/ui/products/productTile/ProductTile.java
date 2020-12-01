package ui.products.productTile;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import shop.Product;
import ui.products.SelectedProductsService;

import java.io.IOException;

public class ProductTile extends VBox {
    private FXMLLoader fxmlLoader;

    private void loadTemplate() {
        fxmlLoader = new FXMLLoader(getClass().getResource(
                "/products/product.fxml"));
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public ProductTile() {
        loadTemplate();
    }

    public void setProduct(Product product) {
        ((ProductTileController)fxmlLoader.getController()).setProduct(product);
    }

    public void setService(SelectedProductsService service) {
        ((ProductTileController)fxmlLoader.getController()).setSelectedProductsService(service);
    }

}
