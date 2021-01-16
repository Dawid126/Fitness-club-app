package ui.products.productDetails;

import enums.Role;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shop.Product;
import ui.dialogs.editDialogs.EditClientDialogController;
import ui.dialogs.editDialogs.EditProductDialogController;
import ui.products.ProductsController;
import ui.products.SelectedProductsService;
import javafx.scene.control.Button;
import utils.LoginManager;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.IOException;
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

    @FXML
    private VBox root;

    @FXML
    public HBox quantityController;
    @FXML
    public Button minusButton;
    @FXML
    public Button plusButton;
    @FXML
    public Button deleteButton;
    @FXML
    public VBox detailsBox;
    @FXML
    public Button editButton;

    private Product product = new Product("", 0, 0, "");

    private FXMLLoader loader;
    private BorderPane page;
    private Stage dialogStage;

    public ProductDetailsController() {

    }

    @FXML
    private void initialize() {
        authoriseRole();
    }

    private void updateProduct(Product newValue) {
        product = newValue;
        descriptionItems.setVisible(true);
        description.setText(newValue.getDescription());
        quantity.setText(String.valueOf(newValue.getQuantity()));
    }

    public void setSelectedProductService(SelectedProductsService selectedProductService) {
        this.selectedProductsService = selectedProductService;
        selectedProductsService.getSelectedProduct()
                .addListener((observable, oldValue, newValue) -> {
                    if (newValue == null) {
                        descriptionItems.setVisible(false);
                    } else {
                        updateProduct(newValue);
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
        selectedProductsService.deleteSelectedProduct();
    }

    @FXML
    private void editProduct() {
        createDialogStage("/products/editProductDialog.fxml");
        ((EditProductDialogController)loader.getController()).setSelectedProductService(selectedProductsService);
        ((EditProductDialogController)loader.getController()).setDialogStage(dialogStage);
        configureDialog("Edit Product");
        dialogStage.showAndWait();
        selectedProductsService.setSelectedProduct(product);
        updateProduct(product);
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

    private void authoriseRole(){
        Role role = LoginManager.getInstance().getLoggedUser().getRole();

        switch (role){
            case ADMIN -> {
                quantityController.getChildren().remove(minusButton);
                quantityController.getChildren().remove(plusButton);
                detailsBox.getChildren().remove(deleteButton);
                detailsBox.getChildren().remove(editButton);
            }
            case RECEPTIONIST -> {
                detailsBox.getChildren().remove(deleteButton);
                detailsBox.getChildren().remove(editButton);
            }
        }
    }
}
