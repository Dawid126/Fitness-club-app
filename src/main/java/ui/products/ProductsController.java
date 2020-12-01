package ui.products;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import persistance.DataManager;
import persistance.IDataManager;
import shop.Product;
import shop.Store;
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
        selectedProductsService = new SelectedProductsService();
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
        IDataManager dataManager = new DataManager();
        var store = new Store(dataManager);
//        AtomicInteger i = new AtomicInteger();
//        store.getProducts().forEach((product) -> {
//            var productTile = new ProductTile();
//            productTile.setProduct(product);
//            productTile.setService(selectedProductsService);
//            productsGrid.add(productTile, i.get() % columns, i.get() / columns);
//            i.getAndIncrement();
//        });
        for (int i = 0; i < productsCount; ++i) {
            var product = new Product("name", 1, 30, "desc" + i);
            var productTile = new ProductTile();
            productTile.setProduct(product);
            productTile.setService(selectedProductsService);
            productsGrid.add(productTile, i % columns, i / columns);
        }
    }


}