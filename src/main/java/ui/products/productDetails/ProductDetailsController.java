package ui.products.productDetails;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import shop.Product;
import ui.products.ProductsController;
import ui.products.SelectedProductsService;
import javafx.scene.control.Button;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailsController {
    private SelectedProductsService selectedProductsService;

    @FXML
    private Text description;
    @FXML
    private Text quantity;
    @FXML
    private VBox descriptionItems;

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
                        descriptionItems.setVisible(false);
                    } else {
                        product = newValue;
                        descriptionItems.setVisible(true);
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

    @FXML
    private void deleteProduct(){
        selectedProductsService.deleteSelectedProduct();
    }
}
