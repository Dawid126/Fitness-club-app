package ui.products;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ProductDetails extends VBox {

    public ProductDetails() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/products/productDetails.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

}
