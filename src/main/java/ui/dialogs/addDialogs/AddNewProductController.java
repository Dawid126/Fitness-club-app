package ui.dialogs.addDialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import shop.Product;
import shop.Store;

import java.io.IOException;

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

    @FXML
    private Text errorName;

    @FXML
    private Text errorDescription;

    @FXML
    private Text errorQuantity;

    @FXML
    private Text errorPrice;

    @FXML
    private Text productSaved;

    @FXML
    private Text imagePath;

    public AddNewProductController() {

    }

    @FXML
    private void initialize() {
        hideErrors();
        imagePath.setText("<img location>");
        productSaved.setVisible(false);
    }

    private void hideErrors() {
        errorName.setVisible(false);
        errorDescription.setVisible(false);
        errorPrice.setVisible(false);
        errorQuantity.setVisible(false);
    }

    private void clear() {
        name.setText("");
        description.setText("");
        price.setText("");
        quantity.setText("");
    }

    private boolean isValid() {
        boolean isValid = true;
        if (name.getText().length() < 1) {
            errorName.setVisible(true);
            isValid = false;
        }
        if (description.getText().length() < 1) {
            errorDescription.setVisible(true);
            isValid = false;
        }
        if(!quantity.getText().matches("-?\\d+")) {
            errorQuantity.setVisible(true);
            isValid = false;
        }
        if(!price.getText().matches("-?\\d+")) {
            errorPrice.setVisible(true);
            isValid = false;
        }
        return isValid;
    }

    @FXML
    private void saveProduct() {
        hideErrors();
        if (!isValid()) {
            return;
        }
        String name = this.name.getText();
        String description = this.description.getText();
        int price = Integer.parseInt(this.price.getText());
        int quantity = Integer.parseInt(this.quantity.getText());
        Store.getInstance().createProduct(name, quantity, price, description);
        Store.getInstance().getProduct(name).setImage(imagePath.getText());
        productSaved.setVisible(true);
        clear();
    }


    public void pickImage(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png")
        );
        imagePath.setText(fileChooser.showOpenDialog(new Stage()).getPath());
    }
}
