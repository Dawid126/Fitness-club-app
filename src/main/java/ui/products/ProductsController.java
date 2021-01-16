package ui.products;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import shop.Store;
import ui.products.productDetails.ProductDetails;
import ui.products.productTile.ProductTile;

import java.util.concurrent.atomic.AtomicInteger;

public class ProductsController {


    private SelectedProductsService selectedProductsService;

    @FXML
    private GridPane productsGrid;

    @FXML
    private ProductDetails productDetails;

    @FXML
    private Text noProductSelectedText;

    public ProductsController() {
        selectedProductsService = new SelectedProductsService(this);
    }

    @FXML
    private void initialize() {
        productDetails.setSelectedProductsService(selectedProductsService);
        initializeGrid();
        noProductSelectedText.visibleProperty().bindBidirectional(selectedProductsService.isNoProductSelected());
        productDetails.visibleProperty().bind(selectedProductsService.isNoProductSelected().not());
    }

    private void initializeGrid() {
        int columns = 3, productsCount = 12;
        var store = Store.getInstance();
        AtomicInteger i = new AtomicInteger();
        productsGrid.getChildren().clear();
        store.getProducts().forEach((product) -> {
            var productTile = new ProductTile();
            productTile.setProduct(product);
            productTile.setService(selectedProductsService);
            productsGrid.add(productTile, i.get() % columns, i.get() / columns);
            i.getAndIncrement();
        });
//        for (int i = 0; i < productsCount; ++i) {
//            var product = new Product("name", 1, 30, "desc" + i);
//            var productTile = new ProductTile();
//            productTile.setProduct(product);
//            productTile.setService(selectedProductsService);
//            productsGrid.add(productTile, i % columns, i / columns);
//        }
    }

    public void notifyChange() {
        initializeGrid();
    }
}