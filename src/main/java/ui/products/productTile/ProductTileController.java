package ui.products.productTile;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import shop.Product;
import ui.products.SelectedProductsService;

public class ProductTileController {

    private SelectedProductsService selectedProductsService;
    private Product product;

    @FXML
    private Button detailsButton;

    @FXML
    private Text productName;

    @FXML
    private Text price;

    public ProductTileController() {
    }

    public void setProduct(Product product) {
        this.product = product;
        productName.setText(product.getName());
        price.setText(String.valueOf(product.getPrice()));
    }

    public void setSelectedProductsService(SelectedProductsService selectedProductsService) {
        this.selectedProductsService = selectedProductsService;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void selectProduct() {
        System.out.println(product);
        if (this.selectedProductsService == null) {
        } else {
            this.selectedProductsService.setSelectedProduct(product);
        }
    }
}
