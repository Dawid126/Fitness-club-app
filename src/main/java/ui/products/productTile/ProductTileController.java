package ui.products.productTile;

import com.sun.tools.javac.Main;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import shop.Product;
import ui.products.SelectedProductsService;

import java.io.ByteArrayInputStream;

public class ProductTileController {

    private SelectedProductsService selectedProductsService;
    private Product product;

    @FXML
    private Button detailsButton;

    @FXML
    private ImageView img;

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
        Image image = new Image(new ByteArrayInputStream(product.getImage()));
        img.setImage(image);
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
