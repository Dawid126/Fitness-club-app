package ui.products;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import ui.products.productTile.ProductTile;

public class ProductsController {

    @FXML
    private GridPane productsGrid;


    @FXML
    private void initialize() {
        initializeGrid();
    }

    private void initializeGrid() {
        int columns = 3;
        int productsCount = 10;
        for (int i = 0; i < productsCount; ++i) {
            productsGrid.add(new ProductTile(), i % columns, i / columns);
        }
    }


}