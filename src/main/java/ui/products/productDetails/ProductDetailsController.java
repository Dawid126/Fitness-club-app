package ui.products.productDetails;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import shop.Product;
import ui.products.SelectedProductsService;

public class ProductDetailsController {
    private SelectedProductsService selectedProductsService;

    @FXML
    private Text description;
    @FXML
    private Text quantity;
    private Product product = new Product("", 0, 0, "");

    public ProductDetailsController() {

    }

    @FXML
    private void initialize() {
    }

    public void setSelectedProductService(SelectedProductsService selectedProductService) {
        this.selectedProductsService = selectedProductService;
        selectedProductsService.getSelectedProduct()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue == null) {
                        description.setText("");
                    } else {
                        product = newValue;
                        description.setText(newValue.getDescription());
                        quantity.setText(String.valueOf(newValue.getQuantity()));
                    }
                });
    }

    @FXML
    private void increaseQuantity() {
        product.setQuantity(product.getQuantity() + 1);
        quantity.setText(String.valueOf(product.getQuantity()));
    }

    @FXML
    private void decreaseQuantity() {
        product.setQuantity(product.getQuantity() - 1);
        quantity.setText(String.valueOf(product.getQuantity()));
    }
}
