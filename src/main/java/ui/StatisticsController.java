package ui;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import utils.StatisticsManager;

public class StatisticsController {

    @FXML
    Text topActivity;

    // @FXML
    // Text topProduct;

    @FXML
    Text topHost;

    // @FXML
    // Text topOrder;

    @FXML
    Text topClient;

    public void initialize() {
        this.topActivity.setText(StatisticsManager.getInstance().getTopActivity().getName());
        // this.topProduct.setText(StatisticsManager.getInstance().getTopProduct().getName());
        this.topHost.setText(StatisticsManager.getInstance().getTopHost().getName());
        // this.topOrder.setText(String.valueOf(StatisticsManager.getInstance().getTopOrder().hashCode()));
        this.topClient.setText(StatisticsManager.getInstance().getTopClient().getName());
    }
}
