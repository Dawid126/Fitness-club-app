package ui.products.productTile;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ProductTile extends VBox {

    public ProductTile() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/products/product.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
