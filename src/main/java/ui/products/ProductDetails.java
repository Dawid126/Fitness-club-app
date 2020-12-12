package ui.products;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import ui.products.productDetails.ProductDetailsController;

import java.io.IOException;

public class ProductDetails extends VBox {

    private FXMLLoader fxmlLoader;

    public ProductDetails() {
        fxmlLoader = new FXMLLoader(getClass().getResource(
                "/products/productDetails.fxml"));
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void setSelectedProductsService(SelectedProductsService service) {
        System.out.println("DODAJe");
        ((ProductDetailsController)fxmlLoader.getController()).setSelectedProductService(service);
    }

}
