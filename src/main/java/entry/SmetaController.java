package entry;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SmetaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button calculate_costs_button;

    @FXML
    private TextField text_air_duct;

    @FXML
    private TextField text_electric_cable;

    @FXML
    private TextField text_from_home_to_septik;

    @FXML
    private TextField text_from_septik_to_trench;

    @FXML
    private TextField total_costs;

    @FXML
    void initialize() {


    }

    public void handleCalculateButton(ActionEvent actionEvent) {
        int lengthFromHomeToSeptik = Integer.parseInt(text_from_home_to_septik.getText());
        int priceFromHomeToSeptik = lengthFromHomeToSeptik*1700;

        int lengthFromSeptikToTrench = Integer.parseInt(text_from_septik_to_trench.getText());
        int priceFromSeptikToTrench = lengthFromSeptikToTrench*1700;

        int lengthAirDuct = Integer.parseInt(text_air_duct.getText());
        int priceAirDuct = lengthAirDuct*100;

        int lengthElectricCable = Integer.parseInt(text_electric_cable.getText());
        int priceElectricCable = lengthElectricCable*570;

        int totalCosts = priceFromHomeToSeptik + priceFromSeptikToTrench + priceAirDuct + priceElectricCable;

        total_costs.setText(Integer.toString(totalCosts));
    }
}
