package ui.addNewProduct;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import shop.Product;
import shop.Store;

public class AddNewProductController {

    @FXML
    private TextField name;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    private TextArea description;

    @FXML
    private Button save;

    public AddNewProductController() {

    }

    @FXML
    private void saveProduct() {
        String name = this.name.getText();
        System.out.println(name);
        String description = this.description.getText();
        System.out.println(description);
        System.out.println(this.price.getText());
        System.out.println(this.quantity.getText());
        int price = Integer.parseInt(this.price.getText());
        int quantity = Integer.parseInt(this.quantity.getText());
        Store.getInstance().createProduct(name, quantity, price, description);
    }


}
