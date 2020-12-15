package ui.products.productDetails;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.Product;
import ui.dialogs.editDialogs.EditProductDialogController;
import ui.products.SelectedProductsService;

import java.io.IOException;

public class ProductDetailsController {
    private SelectedProductsService selectedProductsService;

    @FXML
    private Text description;
    @FXML
    private Text quantity;
    private Product product = new Product("", 0, 0, "");

    @FXML
    private VBox root;

    private FXMLLoader loader;
    private BorderPane page;
    private Stage dialogStage;

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

    @FXML
    private void deleteProduct() {

    }

    @FXML
    private void editProduct() {
        createDialogStage("/products/editProductDialog.fxml");
        ((EditProductDialogController)loader.getController()).setSelectedProduct(product);
        ((EditProductDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Edit Product");
        dialogStage.showAndWait();
    }


    private void configureDialog(String title) {
        dialogStage.setTitle(title);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Scene scene = new Scene(page);
        dialogStage.initOwner(root.getScene().getWindow());
        dialogStage.setScene(scene);
    }

    private void createDialogStage(String fxmlPath) {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        page = null;
        try {
            page = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialogStage = new Stage();
    }
}
