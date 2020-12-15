package ui.dialogs.editDialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.persons.Host;
import shop.Product;
import shop.Store;
import ui.products.SelectedProductsService;
import utils.HostManager;

public class EditProductDialogController {
    @FXML
    private TextField name;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    private TextArea description;

    @FXML
    private Text errorName;

    @FXML
    private Text errorDescription;

    @FXML
    private Text errorQuantity;

    @FXML
    private Text errorPrice;

    private Stage dialogStage;

    private Product product;
    private SelectedProductsService selectedProductsService;

    public void setSelectedProductService(SelectedProductsService selectedProductService){
        this.product = selectedProductService.getSelectedProduct().get();
        name.setText(product.getName());
        this.selectedProductsService = selectedProductService;
        quantity.setText(String.valueOf(product.getQuantity()));
        price.setText(String.valueOf(product.getPrice()));
        description.setText(product.getDescription());
    }

    public EditProductDialogController() {

    }

    @FXML
    private void initialize() {
        hideErrors();
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

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void editProduct() {
        hideErrors();
        if (!isValid()) {
            return;
        }
        if (Store.getInstance().updateProduct(product, name.getText(), Integer.parseInt(quantity.getText()), Integer.parseInt(price.getText()), description.getText())) {
            selectedProductsService.updateSelectedProduct();
            dialogStage.close();
        }
    }
}
